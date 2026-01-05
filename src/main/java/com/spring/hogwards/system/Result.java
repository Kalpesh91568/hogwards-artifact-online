package com.spring.hogwards.system;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result {
    private boolean flag;
    private Integer code;
    private String message;
    private Object data;
}
