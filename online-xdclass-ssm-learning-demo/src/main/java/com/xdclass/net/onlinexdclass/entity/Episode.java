package com.xdclass.net.onlinexdclass.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Data;

/**
 * 小滴课堂 集对象
 *
 * <p>`id` int(11) unsigned NOT NULL AUTO_INCREMENT, `title` varchar(524) DEFAULT NULL COMMENT
 * '集标题', `num` int(10) DEFAULT NULL COMMENT '第几集,全局顺序', `ordered` int(11) DEFAULT NULL COMMENT
 * '顺序，章里面的顺序', `play_url` varchar(256) DEFAULT NULL COMMENT '播放地址', `chapter_id` int(11) DEFAULT
 * NULL COMMENT '章节主键id', `free` tinyint(2) DEFAULT '0' COMMENT '0表示免费，1表示首付', `video_id` int(10)
 * DEFAULT NULL COMMENT '视频id', `create_time` datetime DEFAULT NULL COMMENT '创建时间',
 */
@Data
public class Episode {

  private Integer id;

  private String title;

  private Integer num;

  private Integer ordered;

  @JsonProperty("play_url")
  private String playUrl;

  @JsonProperty("chapter_id")
  private Integer chapterId;

  private Integer free;

  @JsonProperty("video_id")
  private Integer videoId;

  @JsonProperty("create_time")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;
}
