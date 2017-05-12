package com.eprops.eprops.service;

import com.eprops.eprops.error.ErrorCodes;
import com.eprops.eprops.exception.SshCommandException;
import com.eprops.eprops.exception.SshConnectionException;
import com.eprops.eprops.model.SshCommand;
import com.eprops.eprops.model.SshConnection;
import com.eprops.eprops.util.LoggingService;
import com.eprops.eprops.util.SshConnectionHandler;
import com.eprops.eprops.util.StreamToStringService;
import net.schmizz.sshj.connection.channel.direct.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SshCommandRunner {

    private final SshConnectionHandler sshConnectionHandler;
    private final LoggingService loggingService;

    @Autowired
    public SshCommandRunner(SshConnectionHandler sshConnectionHandler, LoggingService loggingService) {
        this.sshConnectionHandler = sshConnectionHandler;
        this.loggingService = loggingService;
    }

    public String executeCommand(SshCommand sshCommand) {
        SshConnection connection = sshConnectionHandler
                .createSession(sshCommand.getEnvironment(), sshCommand.getUser(), sshCommand.getPassword())
                .orElseThrow(SshConnectionException::new);
        try {
            Session.Command c = connection.getSession().exec(sshCommand.getCommand());
            return StreamToStringService.convertStreamToString(c.getInputStream());
        } catch (Exception e) {
            loggingService.error(SshService.class, ErrorCodes.RUN_SSH_COMMAND, "Error while trying to run command " + sshCommand);
            throw new SshCommandException("Problem while trying to execute");
        } finally {
            sshConnectionHandler.closeSession(connection);
        }
    }
}
