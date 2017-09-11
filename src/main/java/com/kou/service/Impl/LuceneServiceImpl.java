package com.kou.service.Impl;

import com.google.common.collect.Lists;
import com.kou.dao.HouseItemMapper;
import com.kou.entity.HouseItem;
import com.kou.service.LuceneService;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

/**
 * Created by KouJiaxing on 2017-9-11.
 */
@Service("luceneService")
public class LuceneServiceImpl implements LuceneService {

    @Autowired
    private HouseItemMapper houseItemMapper;

    // 索引保存目录
    private String indexDir = "D:\\lucene\\index";
    //创建分词器
    private static Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_46);


    @Override
    public boolean createIndex() throws IOException {

        Directory indexDirector = FSDirectory.open(new File(indexDir));
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_46, analyzer);
        IndexWriter indexWriter = new IndexWriter(indexDirector, config);

        List<HouseItem> houseItems = houseItemMapper.selectAll();
        for (HouseItem houseItem : houseItems) {
            Document doc = new Document();
            doc.add(new TextField("id", houseItem.getId().toString(), Field.Store.YES));
            doc.add(new TextField("display_name", houseItem.getDisplayName(), Field.Store.YES));
            doc.add(new TextField("info", houseItem.getHouseInfo(), Field.Store.YES));
            // 将doc添加到索引中
            indexWriter.addDocument(doc);
        }
        indexWriter.commit();
        indexWriter.close();
        return true;
    }


    @Override
    public List<HouseItem> search(String queryStr) throws IOException, ParseException {

        Directory indexDirector = FSDirectory.open(new File(indexDir));
        IndexReader reader = IndexReader.open(indexDirector);
        IndexSearcher searcher = new IndexSearcher(reader);

        QueryParser parser = new QueryParser(Version.LUCENE_46, "info", analyzer);
        Query query = parser.parse(queryStr);
        TopDocs topDocs = searcher.search(query, 10);

        ScoreDoc[] scoreDocs = topDocs.scoreDocs;

        List<HouseItem> result = Lists.newArrayList();
        for (int i = 0; i < scoreDocs.length; i++) {
            int douId = scoreDocs[i].doc;
            Document doc = searcher.doc(douId);
            HouseItem houseItem = new HouseItem();
            houseItem.setId(Integer.parseInt(doc.get("id")));
            houseItem.setDisplayName(doc.get("display_name"));
            houseItem.setHouseInfo(doc.get("info"));
            result.add(houseItem);
        }
        return result;
    }

}
