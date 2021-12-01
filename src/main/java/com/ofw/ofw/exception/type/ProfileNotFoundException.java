package com.ofw.ofw.exception.type;

import com.ofw.ofw.exception.OfwException;
import com.ofw.ofw.exception.error.ErrorCode;

public class ProfileNotFoundException extends OfwException {
    public ProfileNotFoundException() {
        super(ErrorCode.PROFILE_NOT_FOUND);
    }
}
