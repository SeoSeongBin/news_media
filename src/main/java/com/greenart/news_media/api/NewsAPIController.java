package com.greenart.news_media.api;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Delete.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greenart.news_media.mapper.NewsMapper;

@RestController
@RequestMapping("/api/news")
public class NewsAPIController {
    @Autowired NewsMapper news_mapper;
    @GetMapping("/list")
    public Map<String, Object> getNewsList(@RequestParam Integer cate) {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        m.put("NewsList", news_mapper.selectNewsList(cate));
        // List list = news_mapper.selectNewsList(cate);
        return m;
    }
}
