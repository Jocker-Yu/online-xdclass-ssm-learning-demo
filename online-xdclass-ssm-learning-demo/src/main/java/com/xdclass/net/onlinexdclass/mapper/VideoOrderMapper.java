package com.xdclass.net.onlinexdclass.mapper;

import com.xdclass.net.onlinexdclass.entity.VideoOrder;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoOrderMapper {

  /**
   * 查询用户是否购买过此商品
   *
   * @param userId
   * @param videoId
   * @param state
   * @return
   */
  VideoOrder findByUserIdAndVideoIdAndState(
      @Param("user_id") int userId, @Param("video_id") int videoId, @Param("state") int state);

  /**
   * 下单
   *
   * @return
   */
  int saveOrder(VideoOrder videoOrder);

  /**
   * 视频列表
   *
   * @param userId
   * @return
   */
  List<VideoOrder> listOrderByUserId(@Param("user_id") Integer userId);
}
