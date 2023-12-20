package com.xdclass.net.onlinexdclass.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 * 小滴课堂 视频对象
 *
 * <p>`id` int(11) unsigned NOT NULL AUTO_INCREMENT, `title` varchar(524) DEFAULT NULL COMMENT
 * '视频标题', `summary` varchar(1026) DEFAULT NULL COMMENT '概述', `cover_img` varchar(524) DEFAULT NULL
 * COMMENT '封面图', `price` int(11) DEFAULT NULL COMMENT '价格,分', `create_time` datetime DEFAULT NULL
 * COMMENT '创建时间', `point` double(11,2) DEFAULT '8.70' COMMENT '默认8.7，最高10分',
 */
@Data
public class Video {

  private Integer id;

  private String title;

  private String summary;

  @JsonProperty("cover_img")
  private String coverImg;

  private Integer price;

  @JsonProperty("create_time")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  private Double point;

  @JsonProperty("chapter_list")
  private List<Chapter> chapterList;

  private List<Episode> episodeList;
}
