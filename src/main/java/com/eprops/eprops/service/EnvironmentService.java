package com.eprops.eprops.service;

import com.eprops.eprops.exception.ApplicationNotFoundException;
import com.eprops.eprops.model.Application;
import com.eprops.eprops.model.Environment;
import com.eprops.eprops.repository.ApplicationRepository;
import com.eprops.eprops.repository.EnvironmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvironmentService {

    private final EnvironmentRepository environmentRepository;
    private final ApplicationRepository applicationRepository;

    @Autowired
    public EnvironmentService(EnvironmentRepository environmentRepository,
                              ApplicationRepository applicationRepository) {
        this.environmentRepository = environmentRepository;
        this.applicationRepository = applicationRepository;
    }

    public void create(Long applicationId, Environment environment) {
        Application application = applicationRepository.findOne(applicationId);
        if (application == null) {
            throw new ApplicationNotFoundException();
        }
        application.getEnvironments().add(environment);
        environmentRepository.save(environment);
        applicationRepository.save(application);
    }

    public List<Environment> getAll(Long applicationId) {
        Application application = applicationRepository.findOne(applicationId);
        if (application == null) {
            throw new ApplicationNotFoundException();
        }
        return application.getEnvironments();
    }

    public void delete(Long environmentId) {
        environmentRepository.delete(environmentId);
    }

    public void edit(Environment environment) {
        environmentRepository.save(environment);
    }

    public Environment get(Long environmentId) {
        return this.environmentRepository.findOne(environmentId);
    }
}
