package com.eprops.eprops.util;

import com.eprops.eprops.error.ErrorCodes;
import com.eprops.eprops.exception.SshConnectionException;
import com.eprops.eprops.model.SshConnection;
import lombok.extern.slf4j.Slf4j;
import net.schmizz.sshj.SSHClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@Service
public class SshConnectionHandler {

    public final LoggingService loggingService;

    public SshConnectionHandler(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    public Optional<SshConnection> createSession(String environment, String user, String password) {
        SSHClient client = new SSHClient();
        try {
            client.loadKnownHosts();
            client.connect(environment);
            client.authPassword(user, password);
            SshConnection newConnection = new SshConnection();
            newConnection.setSession(client.startSession());
            newConnection.setSshClient(client);
            return Optional.of(newConnection);
        } catch (IOException e) {
            loggingService.error(SshConnectionHandler.class, ErrorCodes.CREATE_SSH_CONNECTION, "Failed when trying to connect to environment:" + environment);
            throw new SshConnectionException(ErrorCodes.CREATE_SSH_CONNECTION);
        }
    }

    public void closeSession(SshConnection sshConnection) {
        try {
            sshConnection.getSession().close();
            sshConnection.getSshClient().disconnect();
        } catch (Exception e) {
            log.error("{}: Problem while trying to close the session", ErrorCodes.CREATE_SSH_CONNECTION.getErrorCode(), "Problem while trying to close the ssh connection");
            throw new SshConnectionException(ErrorCodes.CREATE_SSH_CONNECTION);
        }
    }

}
