package com.eprops.eprops.resource;

import com.eprops.eprops.model.SshCommand;
import com.eprops.eprops.service.SshService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
@RequestMapping("/api/properties")
public class ManagePropertiesResource {

    private final SshService sshService;

    public ManagePropertiesResource(SshService sshService) {
        this.sshService = sshService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Properties> getPropertyFile(@RequestBody SshCommand sshCommand) {
        return new ResponseEntity<>(sshService.readPropertiesFile(sshCommand), HttpStatus.OK);
    }

}
