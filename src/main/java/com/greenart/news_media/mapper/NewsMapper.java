package com.greenart.news_media.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.greenart.news_media.data.NewsInfoVO;

@Mapper
public interface NewsMapper {
    public List<NewsInfoVO> selectNewsList(Integer seq);
}
