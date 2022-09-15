package com.greenart.news_media.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.greenart.news_media.data.AccountInfoVO;

@Mapper
public interface AccountMapper {
    public void putAccount(AccountInfoVO data);
    public boolean isDuplicateId(String id);
    public boolean isDuplicatePhone(String phone);
    public boolean selectLogin(AccountInfoVO data);
    public AccountInfoVO selectAccountLogin(AccountInfoVO data);
    public AccountInfoVO selectSearchId(AccountInfoVO data);
    public AccountInfoVO selectSearchSeq(AccountInfoVO data);
    public boolean selectSearchPwd(String ai_id, String ai_name, String ai_phone);
    public boolean selectSearchCheckId(AccountInfoVO data);
    public void updateUserPwd(Integer seq,String pwd);
    public void updateUserInfo(AccountInfoVO data);
}
