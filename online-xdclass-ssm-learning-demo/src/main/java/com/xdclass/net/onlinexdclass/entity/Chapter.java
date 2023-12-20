package com.xdclass.net.onlinexdclass.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 * 小滴课堂 章对象
 *
 * <p>`id` int(11) unsigned NOT NULL AUTO_INCREMENT, `video_id` int(11) DEFAULT NULL COMMENT '视频主键',
 * `title` varchar(128) DEFAULT NULL COMMENT '章节名称', `ordered` int(11) DEFAULT NULL COMMENT '章节顺序',
 * `create_time` datetime DEFAULT NULL COMMENT '创建时间',
 */
@Data
public class Chapter {

  private Integer id;

  @JsonProperty("video_id")
  private Integer videoId;

  private String title;

  private Integer ordered;

  @JsonProperty("create_time")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  @JsonProperty("episode_list")
  private List<Episode> episodeList;
}
