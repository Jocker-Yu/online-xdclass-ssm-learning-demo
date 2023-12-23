package com.xdclass.net.onlinexdclass.service;

import com.xdclass.net.onlinexdclass.entity.VideoOrder;
import java.util.List;

/**
 * @description: 视频订单服务
 * @author: Joker.yu 2023-12-23 14:54
 */
public interface VideoOrderService {

  /**
   * 下单
   *
   * @param videoId 视频id
   * @param userId 用户id
   */
  void placeOrder(Integer videoId, Integer userId);

  /**
   * 查询当前用户视频订单
   *
   * @param userId 用户id
   * @return 当前订单
   */
  List<VideoOrder> listOrderByUserId(Integer userId);
}
