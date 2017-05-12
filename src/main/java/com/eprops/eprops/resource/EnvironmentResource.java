package com.eprops.eprops.resource;

import com.eprops.eprops.model.Environment;
import com.eprops.eprops.service.EnvironmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/environments")
public class EnvironmentResource {

    private final EnvironmentService environmentService;

    public EnvironmentResource(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody Environment environment) {
        environmentService.create(environment);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Environment>> getAll() {
        return new ResponseEntity<>(environmentService.getAll(), HttpStatus.OK);
    }


}
