package com.eprops.eprops.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Problem while trying to run an ssh command")
public class SshCommandException extends RuntimeException {

    public SshCommandException() {
        super();
    }

    public SshCommandException(String message) {
        super(message);
    }
}
