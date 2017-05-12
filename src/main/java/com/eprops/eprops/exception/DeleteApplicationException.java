package com.eprops.eprops.exception;

import com.eprops.eprops.error.ErrorCode;

public class DeleteApplicationException extends RuntimeException {

    public DeleteApplicationException() {
        super();
    }

    public DeleteApplicationException(String message) {
        super(message);
    }

    public DeleteApplicationException(ErrorCode errorCode) {
        super(errorCode.getReason());
    }
}
