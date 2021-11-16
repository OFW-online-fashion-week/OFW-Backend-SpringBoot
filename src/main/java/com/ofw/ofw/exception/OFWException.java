package com.ofw.ofw.exception;

import com.ofw.ofw.exception.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OFWException extends RuntimeException{
    private ErrorCode errorCode;
}
