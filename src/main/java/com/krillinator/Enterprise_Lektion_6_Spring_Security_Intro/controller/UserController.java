package com.krillinator.Enterprise_Lektion_6_Spring_Security_Intro.controller;

import com.krillinator.Enterprise_Lektion_6_Spring_Security_Intro.authorities.UserRole;
import com.krillinator.Enterprise_Lektion_6_Spring_Security_Intro.model.CustomUser;
import com.krillinator.Enterprise_Lektion_6_Spring_Security_Intro.repository.UserRepository;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String registerUser(Model model) {

        model.addAttribute("customUser", new CustomUser());
        model.addAttribute("userRoles", UserRole.values());

        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid CustomUser customUser, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        userRepository.save(
                new CustomUser(
                        customUser.getUsername(),
                        passwordEncoder.encode(customUser.getPassword()),
                        customUser.getUserRole(),
                        true,
                        true,
                        true,
                        true
                )
        );

        return "redirect:/login";
    }


}
