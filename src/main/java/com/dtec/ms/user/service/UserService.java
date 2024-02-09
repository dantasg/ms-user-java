package com.dtec.ms.user.service;

import com.dtec.ms.user.domain.user.User;
import com.dtec.ms.user.producer.UserProducer;
import com.dtec.ms.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserProducer userProducer;

    @Transactional
    public User save(User user) {
        user = userRepository.save(user);
        userProducer.publishMessageEmail(user);
        return user;
    }
}
