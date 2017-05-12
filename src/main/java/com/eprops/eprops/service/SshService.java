package com.eprops.eprops.service;

import com.eprops.eprops.model.SshCommand;
import com.eprops.eprops.util.SshResultToPropertyFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
@Slf4j
public class SshService {

    private final SshCommandRunner sshCommandRunner;
    private final SshResultToPropertyFile sshResultToPropertyFile;

    @Autowired
    public SshService(SshCommandRunner sshCommandRunner, SshResultToPropertyFile sshResultToPropertyFile) {
        this.sshCommandRunner = sshCommandRunner;
        this.sshResultToPropertyFile = sshResultToPropertyFile;
    }

    public Properties readPropertiesFile(SshCommand sshCommand) {
        String result = sshCommandRunner.executeCommand(sshCommand);
        return sshResultToPropertyFile.createPropertyFile(result);
    }

}
