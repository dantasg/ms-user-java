package com.dtec.ms.user.controller;

import com.dtec.ms.user.domain.user.User;
import com.dtec.ms.user.dtos.UserRecordDto;
import com.dtec.ms.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRecordDto data) {
        User user = new User();
        BeanUtils.copyProperties(data, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }
}
