package com.eprops.eprops.resource;

import com.eprops.eprops.model.Application;
import com.eprops.eprops.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applications")
public class ApplicationResource {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationResource(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Application application) {
        applicationService.create(application);
    }

    @RequestMapping(value = "/{applicationId}", method = RequestMethod.POST)
    public void delete(@PathVariable("applicationId") Long applicationId) {
        applicationService.delete(applicationId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void edit(@RequestBody Application application) {
        applicationService.edit(application);
    }

    @RequestMapping(value = "/{applicationId}", method = RequestMethod.GET)
    public ResponseEntity<Application> get(@PathVariable("applicationId") Long applicationId) {
        return new ResponseEntity<>(applicationService.get(applicationId), HttpStatus.OK);
    }
}
