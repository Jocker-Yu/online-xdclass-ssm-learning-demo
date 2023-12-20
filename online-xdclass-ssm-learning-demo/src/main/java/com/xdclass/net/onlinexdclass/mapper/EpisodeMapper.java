package com.xdclass.net.onlinexdclass.mapper;

import com.xdclass.net.onlinexdclass.entity.Episode;
import org.apache.ibatis.annotations.Param;

public interface EpisodeMapper {

  Episode findFirstEpisodeByVideoId(@Param("video_id") int videoId);
}
