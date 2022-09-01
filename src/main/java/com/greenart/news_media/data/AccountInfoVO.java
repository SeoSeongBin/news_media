package com.greenart.news_media.data;

import java.util.Date;

import lombok.Data;

@Data
public class AccountInfoVO {
    private Integer ai_seq;
    private String ai_id;
    private String ai_pwd;
    private String ai_name;
    private Date ai_reg_dt;
    private Integer ai_status;
    private Integer ai_grade;
}
