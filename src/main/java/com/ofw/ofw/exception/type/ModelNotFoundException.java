package com.ofw.ofw.exception.type;

import com.ofw.ofw.exception.OfwException;
import com.ofw.ofw.exception.error.ErrorCode;

public class ModelNotFoundException extends OfwException {
    public ModelNotFoundException() {
        super(ErrorCode.MODEL_NOT_FOUND);
    }
}
