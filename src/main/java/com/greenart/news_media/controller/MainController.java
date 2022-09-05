package com.greenart.news_media.controller;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public String getMain() {
        return "/index";
    }

    @GetMapping("/news")
    public String getCatePage(@RequestParam Integer cate) {

        return "/news/news";
    }
    @GetMapping("/user/{name}")
    public String getUserPath(@PathVariable String name) {
        return "/user/"+name;
    }
}
