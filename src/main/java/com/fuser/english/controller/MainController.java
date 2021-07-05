package com.fuser.english.controller;

import com.fuser.english.entity.User;
import com.fuser.english.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/users")
    public ModelAndView users(ModelAndView model){
        model.addObject("list", userService.getAll());
        model.setViewName("users");
        return model;
    }

    @GetMapping("/admin")
    public ModelAndView admin(ModelAndView model){
        model.addObject("list", userService.getAll());
        model.setViewName("admin");
        return model;
    }

    @PostMapping("/add")
    public ModelAndView addingUser(@Param("newUser") User user, ModelAndView model){
        userService.addUser(user);
        model.addObject("list", userService.getAll());
        model.setViewName("redirect:/admin");
        return model;
    }

    @PostMapping("/getGems")
    public ModelAndView getUserGems(@Param("getGems") int id, ModelAndView model){
        model.setViewName("redirect:/admin");
        model.addObject("gems", userService.getUserGems(id));
        return model;
    }



}
