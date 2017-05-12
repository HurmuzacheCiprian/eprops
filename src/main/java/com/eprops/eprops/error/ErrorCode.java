package com.eprops.eprops.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorCode {
    private int errorCode;
    private String reason;
}
