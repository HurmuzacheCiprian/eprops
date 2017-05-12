package com.eprops.eprops.resource;

import com.eprops.eprops.model.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.eprops.eprops.model.Status.RUNNING;

@RestController
@RequestMapping("/status")
public class StatusResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Status> status() {
        return new ResponseEntity<>(RUNNING, HttpStatus.OK);
    }

}
