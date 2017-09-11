package com.kou.service;

import com.kou.entity.HouseItem;
import org.apache.lucene.queryparser.classic.ParseException;

import java.io.IOException;
import java.util.List;

/**
 * Created by KouJiaxing on 2017-9-11.
 */
public interface LuceneService {
    boolean createIndex() throws IOException;

    List<HouseItem> search(String queryStr) throws IOException, ParseException;

}
