package com.ofw.ofw.exception.type;

import com.ofw.ofw.exception.OfwException;
import com.ofw.ofw.exception.error.ErrorCode;

public class DesignerNotFoundException extends OfwException {
    public DesignerNotFoundException() {
        super(ErrorCode.DESIGNER_NOT_FOUND);
    }
}
