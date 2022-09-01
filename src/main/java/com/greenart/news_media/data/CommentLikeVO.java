package com.greenart.news_media.data;

import java.util.Date;

import lombok.Data;

@Data
public class CommentLikeVO {
    private Integer cl_seq;
    private Integer cl_ci_seq;
    private Integer cl_ai_seq;
    private Integer cl_like_dislike;
    private Date cl_reg_dt;
    private Date cl_mod_dt;
}
