package com.ofw.ofw.exception.type;

import com.ofw.ofw.exception.OfwException;
import com.ofw.ofw.exception.error.ErrorCode;

public class RunwayNotFoundException extends OfwException {
    public RunwayNotFoundException() {
        super(ErrorCode.RUNWAY_NOT_FOUND);
    }
}
