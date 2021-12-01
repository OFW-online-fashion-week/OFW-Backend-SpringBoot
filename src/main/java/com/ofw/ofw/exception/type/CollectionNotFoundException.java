package com.ofw.ofw.exception.type;

import com.ofw.ofw.exception.OfwException;
import com.ofw.ofw.exception.error.ErrorCode;

public class CollectionNotFoundException extends OfwException {
    public CollectionNotFoundException() {
        super(ErrorCode.COLLECTION_NOT_FOUND);
    }

}
