package com.flowerbooking.controller;

import com.flowerbooking.model.User;
import com.flowerbooking.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/register")
    public String showUserForm(Model model){
        model.addAttribute("user",new User());
        return "register-form";
    }

    @PostMapping("/register")
    public String userRegister(@RequestBody User user){
            String hashPwd=passwordEncoder.encode(user.getPassword());
            user.setPassword(hashPwd);
            userRepo.save(user);
        return "redirect:/flower/all";
    }
}
