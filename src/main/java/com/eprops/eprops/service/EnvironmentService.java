package com.eprops.eprops.service;

import com.eprops.eprops.model.Environment;
import com.eprops.eprops.repository.EnvironmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvironmentService {

    private final EnvironmentRepository environmentRepository;

    @Autowired
    public EnvironmentService(EnvironmentRepository environmentRepository) {
        this.environmentRepository = environmentRepository;
    }

    public void create(Environment environment) {
        environmentRepository.save(environment);
    }

    public List<Environment> getAll() {
        return environmentRepository.findAll();
    }

}
