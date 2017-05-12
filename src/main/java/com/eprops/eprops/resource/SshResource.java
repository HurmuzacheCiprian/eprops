package com.eprops.eprops.resource;

import com.eprops.eprops.model.SshCommand;
import com.eprops.eprops.service.SshService;
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

    private final SshService sshService;

    @Autowired
    public SshResource(SshService sshService) {
        this.sshService = sshService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> execute(@RequestBody SshCommand command) {
        return new ResponseEntity<>(sshService.executeCommand(command), HttpStatus.OK);
    }

}
