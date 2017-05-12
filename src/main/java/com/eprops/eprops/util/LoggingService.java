package com.eprops.eprops.util;

import com.eprops.eprops.error.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoggingService {

    public <T> void error(Class<T> clazz, ErrorCode errorCode, String additionalReason) {
        log.error("class=[{}],errorCode=[{}], reason=[{}], additionalReason=[{}]",
                clazz,
                errorCode.getErrorCode(),
                errorCode.getReason(),
                additionalReason);
    }
}
