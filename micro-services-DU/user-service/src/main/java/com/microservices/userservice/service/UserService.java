package com.microservices.userservice.service;

import com.microservices.userservice.VO.Department;
import com.microservices.userservice.VO.ResponseTemaplteVO;
import com.microservices.userservice.entity.User;
import com.microservices.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ObjectDeletedException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public User save(User user) {
        log.info("Inside saveUser of UserService");
        return repository.save(user);
    }

    public ResponseTemaplteVO getUserDeparment(Long userId) {
        log.info("Inside saveUser of UserService");
        ResponseTemaplteVO vo = new ResponseTemaplteVO();
        Optional<User> user = repository.findById(userId);

        log.info("Call microservice user");
        Department department = restTemplate.getForObject("http://localhost:9001/departments/" + user.get().getDepartmenId(), Department.class);

        vo.setUser(user.get());
        vo.setDepartment(department);

        return vo;
    }
}
