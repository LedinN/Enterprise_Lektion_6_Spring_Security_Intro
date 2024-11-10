package com.krillinator.Enterprise_Lektion_6_Spring_Security_Intro.controller;

import com.krillinator.Enterprise_Lektion_6_Spring_Security_Intro.authorities.UserRole;
import com.krillinator.Enterprise_Lektion_6_Spring_Security_Intro.model.CustomUser;
import com.krillinator.Enterprise_Lektion_6_Spring_Security_Intro.repository.UserRepository;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String registerUser(Model model) {

        model.addAttribute("user", new CustomUser());

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
                        customUser.getPassword(),
                        UserRole.USER,
                        true,
                        true,
                        true,
                        true
                )
        );

        return "redirect:/login";
    }


}
