package com.eprops.eprops.error;

public final class ErrorCodes {

    private ErrorCodes() {
        throw new UnsupportedOperationException("This constructor should not be invoked!");
    }

    public static final ErrorCode CREATE_SSH_CONNECTION = new ErrorCode(1000, "Error while trying to create the ssh connection");
    public static final ErrorCode CLOSE_SSH_CONNECTION = new ErrorCode(10002, "Error while trying to close the ssh connection");
    public static final ErrorCode RUN_SSH_COMMAND = new ErrorCode(10003, "Error while trying to close and ssh command");
    public static final ErrorCode DELETE_APPLICATION_EXCEPTION = new ErrorCode(10004, "Error while trying to delete an application. It doesn't exist or there is some error with the database");

}
