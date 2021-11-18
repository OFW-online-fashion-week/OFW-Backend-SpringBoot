package com.ofw.ofw.exception.type;

import com.ofw.ofw.exception.OfwException;
import com.ofw.ofw.exception.error.ErrorCode;

public class UserNotFoundException extends OfwException {
    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
