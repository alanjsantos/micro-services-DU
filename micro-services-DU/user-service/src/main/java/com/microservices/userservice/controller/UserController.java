package com.microservices.userservice.controller;

import com.microservices.userservice.VO.ResponseTemaplteVO;
import com.microservices.userservice.entity.User;
import com.microservices.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public User save(@RequestBody User user) {
        log.info("Inside saveUser of UserController");
        return service.save(user);
    }

    @GetMapping("/{id}")
    public ResponseTemaplteVO getUsersWithDepartment(@PathVariable Long id) {
        log.info("Inside getUserWithDepartment");
        return service.getUserDeparment(id);
    }
}
