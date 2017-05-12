package com.eprops.eprops.resource;

import com.eprops.eprops.model.Environment;
import com.eprops.eprops.service.EnvironmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class EnvironmentResource {

    private final EnvironmentService environmentService;

    public EnvironmentResource(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }

    @RequestMapping(value = "/{applicationId}/environments", method = RequestMethod.POST)
    public void create(@PathVariable("applicationId") Long applicationId,
                       @RequestBody Environment environment) {
        environmentService.create(applicationId, environment);
    }

    @RequestMapping(value = "/{applicationId}/environments", method = RequestMethod.GET)
    public ResponseEntity<List<Environment>> getAll(@PathVariable("applicationId") Long applicationId) {
        return new ResponseEntity<>(environmentService.getAll(applicationId), HttpStatus.OK);
    }

    @RequestMapping(value = "/environments/{environmentId}", method = RequestMethod.POST)
    public void delete(@PathVariable("environmentId") Long environmentId) {
        environmentService.delete(environmentId);
    }

    @RequestMapping(value = "/environments/{environmentId}", method = RequestMethod.POST)
    public void edit(@RequestBody Environment environment) {
        environmentService.edit(environment);
    }

}
