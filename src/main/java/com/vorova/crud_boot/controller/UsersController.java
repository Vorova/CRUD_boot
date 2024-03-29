package com.vorova.crud_boot.controller;

import com.vorova.crud_boot.model.User;
import com.vorova.crud_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String greeting(Model model) {
        String title = "Старница с пользователями";
        model.addAttribute("title", title);
        model.addAttribute("users", userService.allUsers());
        model.addAttribute("user", new User());
        return "index";
    }
    @PostMapping(value = "/add")
    public String add(@ModelAttribute User user) {
        userService.saveOrUpdate(user);
        return "redirect:/";
    }

    @GetMapping(value="/delete/{id}")
    public String delete(@PathVariable long id) {
        userService.delete(id);
        return "redirect:/";
    }

    @GetMapping(value="/edit/{id}")
    public String edit(@PathVariable long id, ModelMap model) {
        model.addAttribute("user", userService.getById(id));
        return "edit";
    }

    @PostMapping(value="/save")
    public String save(@ModelAttribute User user) {
        userService.saveOrUpdate(user);
        return "redirect:/";
    }

}
