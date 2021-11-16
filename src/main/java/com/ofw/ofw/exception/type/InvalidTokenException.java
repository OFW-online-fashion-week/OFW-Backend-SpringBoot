package com.ofw.ofw.exception.type;

import com.ofw.ofw.exception.OfwException;
import com.ofw.ofw.exception.error.ErrorCode;

public class InvalidTokenException extends OfwException {
    public InvalidTokenException() {
        super(ErrorCode.INVALID_INPUT_VALUE);
    }
}
