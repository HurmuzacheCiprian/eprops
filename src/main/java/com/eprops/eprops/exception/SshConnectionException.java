package com.eprops.eprops.exception;

import com.eprops.eprops.error.ErrorCode;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Problem while trying to create an ssh connection")
public class SshConnectionException extends RuntimeException {

    public SshConnectionException() {
        super();
    }

    public SshConnectionException(String message) {
        super(message);
    }

    public SshConnectionException(ErrorCode errorCode) {
        super(errorCode.getReason());
    }

}
