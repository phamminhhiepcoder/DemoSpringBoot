package com.t3h.demospring2.controller;

import com.t3h.demospring2.entity.User;
import com.t3h.demospring2.service.impl.IUserServiceImpl;
import jakarta.jws.WebParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
//    @GetMapping()
//    public String getUsers(Model model){
//        model.addAttribute("nameClass", "ljava2209");
//        return "user";
//    }


    @Autowired
    private IUserServiceImpl iUserService;
    @GetMapping
    public String getUsers(Model model){
        List<User> users = iUserService.getAllUser();
        model.addAttribute("users", users);
        return "user";
    }
}
