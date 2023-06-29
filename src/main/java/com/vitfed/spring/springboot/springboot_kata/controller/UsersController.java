package com.vitfed.spring.springboot.springboot_kata.controller;

import com.vitfed.spring.springboot.springboot_kata.model.User;
import com.vitfed.spring.springboot.springboot_kata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String listUser(ModelMap modelMap) {
        modelMap.addAttribute("list", userService.getAllUsers());
        return "getUserList";
    }

    @GetMapping("/create")
    public String newUser(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "create";
    }

    @PostMapping(value = "/create")
    public String newUser(@Valid @ModelAttribute User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            userService.save(user);
            return "redirect:/user/";
        }

    }

    @GetMapping(value = "/update/{id}")
    public String editUser(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.getById(id));
        return "updateUser";
    }

    @PostMapping(value = "/update/{id}")
    public String editUser(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateUser";
        } else {
            userService.update(user);
            return "redirect:/user/";
        }
    }
        @GetMapping(value = "/delete/{id}")
        public String deleteUser (@PathVariable("id") Long id){
            userService.delete(id);
            return "redirect:/user/";
        }
    }

