package com.kou.controller;

import com.google.common.collect.Maps;
import com.kou.dao.HouseItemMapper;
import com.kou.service.LuceneService;
import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

/**
 * Created by KouJiaxing on 2017-9-11.
 */
@RestController
@RequestMapping("/house")
public class HouseItemController {

    @Autowired
    private HouseItemMapper houseItemMapper;
    @Autowired
    private LuceneService luceneService;

    @RequestMapping(value = "/test", method = {RequestMethod.GET, RequestMethod.POST})
    public Object house() throws IOException {
        Map<String, Object> condition = Maps.newHashMap();
        condition.put("id", 10);

        luceneService.createIndex();

        return houseItemMapper.selectByCondition(condition);
    }

    @GetMapping(value = "/query")
    public Object queryHouse(@RequestParam("info") String info) {
        try {
            return luceneService.search(info);
        } catch (IOException e) {
            e.printStackTrace();
            return e;
        } catch (ParseException e) {
            e.printStackTrace();
            return e;
        }
    }

}
