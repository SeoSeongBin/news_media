package com.greenart.news_media.data;

import java.util.Date;

import lombok.Data;

@Data
public class NewsScoreVO {
    private Integer ns_seq;
    private Integer ns_ni_seq;
    private Integer ns_ai_seq;
    private Integer ns_score;
    private Date ns_reg_dt;
    private Date ns_mod_dt;
}
