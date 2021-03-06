package com.example.todolist.controller;

import com.example.todolist.domain.Role;
import com.example.todolist.domain.User;
import com.example.todolist.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(com.example.todolist.domain.User user, Map<String,Object> model){
        User userFromDB = userRepo.findByUsername(user.getUsername());
        if (userFromDB != null) {
            model.put("message","Пользователь существует!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        return "redirect:/login";
    }
}
