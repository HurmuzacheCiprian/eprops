package com.eprops.eprops.resource;

import com.eprops.eprops.model.Response;
import com.eprops.eprops.model.SshCommand;
import com.eprops.eprops.service.SshCommandRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ssh-commands")
public class SshResource {

    private final SshCommandRunner sshCommandRunner;

    @Autowired
    public SshResource(SshCommandRunner sshCommandRunner) {
        this.sshCommandRunner = sshCommandRunner;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Response> execute(@RequestBody SshCommand command) {
        Response response = new Response(sshCommandRunner.executeCommand(command));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
