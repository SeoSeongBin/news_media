package com.greenart.news_media.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.greenart.news_media.data.CategoryInfoVO;

@Mapper
public interface CategoryMapper {
    public List<CategoryInfoVO> selectCateList();
}
