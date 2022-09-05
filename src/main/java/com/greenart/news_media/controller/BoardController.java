package com.greenart.news_media.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
    @GetMapping("/news_write")
    public String getNewsWrite() {

        return "/board/news_write";
    }
}
