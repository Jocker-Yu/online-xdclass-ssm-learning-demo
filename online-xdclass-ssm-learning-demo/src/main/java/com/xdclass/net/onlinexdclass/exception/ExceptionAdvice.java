package com.xdclass.net.onlinexdclass.exception;

import com.google.gson.Gson;
import com.xdclass.net.onlinexdclass.utils.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @description: 全局异常处理
 * @author: Joker.yu 2023-12-22 15:10
 */
@ControllerAdvice("com.xdclass.net.onlinexdclass")
public class ExceptionAdvice implements ResponseBodyAdvice<Object> {

  private static final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

  private final Gson gson = new Gson();

  @Override
  public boolean supports(
      MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
    return true;
  }

  @Override
  public Object beforeBodyWrite(
      Object body,
      MethodParameter returnType,
      MediaType selectedContentType,
      Class<? extends HttpMessageConverter<?>> selectedConverterType,
      ServerHttpRequest request,
      ServerHttpResponse response) {
    // 如果返回的结果是JsonData对象，即已经封装好的，直接返回即可。
    // 如果不进行这个判断，后面进行全局异常处理时会出现错误
    if (body instanceof JsonData) {
      return body;
    } else {
      // 如果Controller返回String的话，SpringBoot不会帮我们自动封装而直接返回,因此我们需要手动转换成json,避免springmvc的类型结果转换错误
      JsonData jsonData = JsonData.buildSuccess(body);
      if (body instanceof String) {
        // text_plain情况下强制返回json头部，并将内容转换为string
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return gson.toJson(jsonData);
      }
      return jsonData;
    }
  }

  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  public JsonData handle(Exception e) {
    logger.error("ExceptionAdvice.handleException: message[{}]", e.getMessage(), e);
    return JsonData.buildError("全局异常，未知错误");
  }

  @ExceptionHandler(value = XDException.class)
  @ResponseBody
  public JsonData handle(XDException xdException) {
    logger.debug(
        "ExceptionAdvice.handleException: message[{}], errormessage[{}]",
        xdException.getMessage(),
        xdException.getMsg(),
        xdException);
    return JsonData.buildError(xdException.getCode(), xdException.getMsg());
  }
}
