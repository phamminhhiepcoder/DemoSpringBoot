package com.t3h.demoSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public String getUser(Model model){
        model.addAttribute("nameClass", "ljava2209");
        return "user";
    }


}
