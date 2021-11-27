package com.ofw.ofw.exception.type;

import com.ofw.ofw.exception.OfwException;
import com.ofw.ofw.exception.error.ErrorCode;

public class BrandCacheNotFoundException extends OfwException {
    public BrandCacheNotFoundException() {
        super(ErrorCode.BRAND_CACHE_NOT_FOUND);
    }
}
