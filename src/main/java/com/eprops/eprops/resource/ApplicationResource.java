package com.eprops.eprops.resource;

import com.eprops.eprops.model.Application;
import com.eprops.eprops.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationResource {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationResource(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody Application application) {
        applicationService.create(application);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{applicationId}", method = RequestMethod.POST)
    public ResponseEntity delete(@PathVariable("applicationId") Long applicationId) {
        applicationService.delete(applicationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity edit(@RequestBody Application application) {
        applicationService.edit(application);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{applicationId}", method = RequestMethod.GET)
    public ResponseEntity<Application> get(@PathVariable("applicationId") Long applicationId) {
        return new ResponseEntity<>(applicationService.get(applicationId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Application>> getAll() {
        return new ResponseEntity<>(applicationService.getAll(), HttpStatus.OK);
    }
}
