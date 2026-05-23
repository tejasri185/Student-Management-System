package net.javaguides.sms.controller;

import net.javaguides.sms.entity.User;
import net.javaguides.sms.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService,
                          PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    // ---------- LOGIN PAGE (GET) ----------
    @GetMapping("/login")
    public String loginPage() {
        // IMPORTANT: do NOT redirect here, just return view name
        return "login";                  // -> templates/login.html
    }

    // ---------- REGISTER PAGE (GET) ----------
    @GetMapping("/register")
    public String showRegistrationForm(
            Model model,
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "registered", required = false) String registered) {

        model.addAttribute("user", new User());
        model.addAttribute("error", error);
        model.addAttribute("registered", registered);
        return "register";               // -> templates/register.html
    }

    // ---------- REGISTER SUBMIT (POST) ----------
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {

        if (user.getEmail() == null || user.getEmail().isBlank()) {
            return "redirect:/register?error=missingEmail";
        }
        if (user.getPassword() == null || user.getPassword().isBlank()) {
            return "redirect:/register?error=missingPassword";
        }

        Optional<User> existing = Optional.ofNullable(userService.findByEmail(user.getEmail()));
        if (existing.isPresent()) {
            return "redirect:/register?error=emailExists";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);

        return "redirect:/register?registered=true";
    }
}