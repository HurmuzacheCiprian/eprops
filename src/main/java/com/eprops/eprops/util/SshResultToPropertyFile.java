package com.eprops.eprops.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

@Service
@Slf4j
public class SshResultToPropertyFile {

    public Properties createPropertyFile(String result) {
        final Properties p = new Properties();
        try {
            p.load(new StringReader(result));
        } catch (IOException e) {
            log.error("Problem while trying to parse the string result into a Properties object");
        }
        return p;
    }
}
