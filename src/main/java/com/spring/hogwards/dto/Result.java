package com.spring.hogwards.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class Result {
  private boolean flag;
  private Integer code;
  private String message;
  private Object data;

  public Result(boolean flag, Integer code, String message, Object data) {
    this.flag = flag;
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public Result(boolean flag, Integer code, String message) {
    this.flag = flag;
    this.code = code;
    this.message = message;
  }
}
