 package net.javaguides.sms.controller;

import net.javaguides.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.javaguides.sms.service.UserService;

@Controller
public class DashboardController {

    @Autowired
    private StudentService studentService;

    private final UserService userService;

    DashboardController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Authentication auth) {

        String loggedUserEmail = auth.getName();

        Model attribute = model.addAttribute("totalUsers", userService.countUsers());
        model.addAttribute("loggedUser", loggedUserEmail);

        return "dashboard";
    }
}