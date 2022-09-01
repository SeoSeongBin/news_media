package com.greenart.news_media.data;

import java.util.Date;

import lombok.Data;

@Data
public class CommentInfoVO {
    private Integer ci_seq;
    private Integer ci_ai_seq;
    private String ci_summary;
    private Date ci_reg_dt;
    private Date ci_mod_dt;
}
