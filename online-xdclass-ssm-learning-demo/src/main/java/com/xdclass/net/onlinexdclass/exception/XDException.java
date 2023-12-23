package com.xdclass.net.onlinexdclass.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @description: 异常
 * @author: Joker.yu 2023-12-22 15:11
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class XDException extends RuntimeException {

  private Integer code;

  private String msg;

  public XDException(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }
}
