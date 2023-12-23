package com.xdclass.net.onlinexdclass.controller;

import com.xdclass.net.onlinexdclass.controller.request.VideoOrderRequest;
import com.xdclass.net.onlinexdclass.entity.VideoOrder;
import com.xdclass.net.onlinexdclass.service.VideoOrderService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 视频下单接口
 * @author: Joker.yu 2023-12-23 14:49
 */
@RestController
@RequestMapping("api/v1/pri/order")
public class VideoOrderController {

  @Autowired private VideoOrderService videoOrderService;

  /**
   * 下单
   *
   * @param videoOrderRequest 下单请求体
   * @param request request
   */
  @PostMapping("save")
  public void placeOrder(
      @RequestBody VideoOrderRequest videoOrderRequest, HttpServletRequest request) {
    videoOrderService.placeOrder(
        videoOrderRequest.getVideoId(), (Integer) request.getAttribute("user_id"));
  }

  /**
   * 订单列表
   *
   * @param request
   * @return
   */
  @GetMapping("list")
  public List<VideoOrder> listOrder(HttpServletRequest request) {
    Integer userId = (Integer) request.getAttribute("user_id");
    return videoOrderService.listOrderByUserId(userId);
  }
}
