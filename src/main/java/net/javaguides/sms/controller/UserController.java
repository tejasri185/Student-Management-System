package net.javaguides.sms.controller;

 /*import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import net.javaguides.sms.entity.User;
import net.javaguides.sms.service.UserService;*/

// @Controller
public class UserController {

    /*private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(User user, Model model) {
        if(userService.existsByEmail(user.getEmail())) {
            model.addAttribute("error", "Email already exists!");
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/login";
    }*/
}
