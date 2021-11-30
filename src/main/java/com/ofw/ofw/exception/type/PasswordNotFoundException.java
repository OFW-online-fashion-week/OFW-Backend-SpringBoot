package com.ofw.ofw.exception.type;

import com.ofw.ofw.exception.OfwException;
import com.ofw.ofw.exception.error.ErrorCode;

public class PasswordNotFoundException extends OfwException {
    public PasswordNotFoundException() {
        super(ErrorCode.PASSWORD_NOT_FOUND);
    }
}
