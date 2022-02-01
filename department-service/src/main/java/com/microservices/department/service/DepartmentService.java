package com.microservices.department.service;

import com.microservices.department.entity.Department;
import com.microservices.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public Department save(Department department) {
        log.info("Inside saveDepartment of DepartmentService");
        return repository.save(department);
    }

    public Department findById (Long id) {
        Optional<Department> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(1, "Object not FOUND."));
    }
}
