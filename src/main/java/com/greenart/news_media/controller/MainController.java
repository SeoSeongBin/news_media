package com.greenart.news_media.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
    @GetMapping("/")
    public String getMain() {
        return "/index";
    }

    @GetMapping("/{name}")
    public String getCatePage(@PathVariable String name) {

        return "/cate/"+name;
    }
}
