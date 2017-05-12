package com.eprops.eprops.resource;

import com.eprops.eprops.model.Environment;
import com.eprops.eprops.service.EnvironmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EnvironmentResource {

    private final EnvironmentService environmentService;

    public EnvironmentResource(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }

    @RequestMapping(value = "/applications/{applicationId}/environments", method = RequestMethod.POST)
    public void create(@PathVariable("applicationId") Long applicationId,
                       @RequestBody Environment environment) {
        environmentService.create(applicationId, environment);
    }

    @RequestMapping(value = "/applications/{applicationId}/environments", method = RequestMethod.GET)
    public ResponseEntity<List<Environment>> getAll(@PathVariable("applicationId") Long applicationId) {
        return new ResponseEntity<>(environmentService.getAll(applicationId), HttpStatus.OK);
    }

    @RequestMapping(value = "/applications/environments/{environmentId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("environmentId") Long environmentId) {
        environmentService.delete(environmentId);
    }

    @RequestMapping(value = "/applications/environments/{environmentId}", method = RequestMethod.PUT)
    public void edit(@RequestBody Environment environment) {
        environmentService.edit(environment);
    }

}
