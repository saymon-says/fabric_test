package com.example.fabric.service;

import com.example.fabric.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User findByAuthentication();

}
