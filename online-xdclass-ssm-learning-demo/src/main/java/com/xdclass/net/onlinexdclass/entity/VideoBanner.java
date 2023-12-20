package com.xdclass.net.onlinexdclass.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Data;

/**
 * 小滴课堂 视频轮播图
 *
 * <p>`id` int(11) unsigned NOT NULL AUTO_INCREMENT, `url` varchar(256) DEFAULT NULL COMMENT '跳转地址',
 * `img` varchar(256) DEFAULT NULL COMMENT '图片地址', `create_time` datetime DEFAULT NULL, `weight`
 * int(11) DEFAULT NULL COMMENT '数字越小排越前',
 */
@Data
public class VideoBanner {

  private Integer id;

  private String url;

  private String img;

  @JsonProperty("create_time")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  private Integer weight;
}
