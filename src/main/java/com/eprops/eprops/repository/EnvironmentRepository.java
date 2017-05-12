package com.eprops.eprops.repository;

import com.eprops.eprops.model.Environment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvironmentRepository extends JpaRepository<Environment, Long> {
}
