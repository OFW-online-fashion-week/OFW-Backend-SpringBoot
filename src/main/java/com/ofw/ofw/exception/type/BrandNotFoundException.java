package com.ofw.ofw.exception.type;

import com.ofw.ofw.exception.OfwException;
import com.ofw.ofw.exception.error.ErrorCode;

public class BrandNotFoundException extends OfwException {
    public BrandNotFoundException() {
        super(ErrorCode.BRAND_NOT_FOUND);
    }
}
