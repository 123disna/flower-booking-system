package com.flowerbooking.service;

import com.flowerbooking.model.User;
import com.flowerbooking.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User getUserById(int id) {
        User user=userRepo.findById(id).get();
        return user;
    }
}
