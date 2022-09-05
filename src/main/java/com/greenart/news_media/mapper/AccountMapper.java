package com.greenart.news_media.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.greenart.news_media.data.AccountInfoVO;

@Mapper
public interface AccountMapper {
    public void putAccount(AccountInfoVO data);
    public boolean isDuplicateId(String id);
    public boolean isDuplicatePhone(String phone);
}
