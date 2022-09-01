package com.greenart.news_media.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenart.news_media.mapper.CategoryMapper;

@RestController
@RequestMapping("/api/cate")
public class CategoryAPIController {
    @Autowired CategoryMapper cate_mapper;
    @GetMapping("/list")
    public Map<String, Object> getCateList() {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        m.put("cateList", cate_mapper.selectCateList());
        return m;
    }
}
