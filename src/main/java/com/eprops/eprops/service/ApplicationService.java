package com.eprops.eprops.service;

import com.eprops.eprops.error.ErrorCodes;
import com.eprops.eprops.exception.DeleteApplicationException;
import com.eprops.eprops.model.Application;
import com.eprops.eprops.repository.ApplicationRepository;
import com.eprops.eprops.util.LoggingService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final LoggingService loggingService;

    public ApplicationService(ApplicationRepository applicationRepository,
                              LoggingService loggingService) {
        this.applicationRepository = applicationRepository;
        this.loggingService = loggingService;
    }

    public void create(Application application) {
        applicationRepository.save(application);
    }

    public void delete(Long applicationId) {
        try {
            applicationRepository.delete(applicationId);
        } catch (EmptyResultDataAccessException ex) {
            loggingService.error(ApplicationService.class, ErrorCodes.DELETE_APPLICATION_EXCEPTION, ErrorCodes.DELETE_APPLICATION_EXCEPTION.getReason());
            throw new DeleteApplicationException(ErrorCodes.DELETE_APPLICATION_EXCEPTION);
        }
    }

    public void edit(Application application) {
        applicationRepository.save(application);
    }

    public Application get(Long applicationId) {
        return applicationRepository.findOne(applicationId);
    }
}
