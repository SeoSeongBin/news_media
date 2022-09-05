package com.greenart.news_media.data;

import java.util.Date;

import lombok.Data;

@Data
public class NewsInfoVO {
    private Integer ni_seq;
    private Integer ni_mi_seq;
    private Integer ni_ai_seq;
    private Integer ni_cai_seq;
    private Integer ni_ns_seq;
    private String ni_img;
    private String ni_title;
    private String ni_summary;
    private Date ni_reg_dt;
    private Date ni_mod_dt;
    private String mi_name;
    private String ai_id;
    private String ai_name;
}
