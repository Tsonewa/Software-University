package com.example.pathfinder.web;

import com.example.pathfinder.models.enums.view.UserProfileViewModel;
import com.example.pathfinder.servers.UserService;
import com.example.pathfinder.utils.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {

    private final CurrentUser currentUser;
    private final UserService userService;

    public ProfileController(CurrentUser currentUser, UserService userService) {
        this.currentUser = currentUser;
        this.userService = userService;
    }

    @GetMapping("profile/{username}")
    public String getProfile(@PathVariable String username,
                             Model model){

        UserProfileViewModel userProfile =
                userService.getUserProfile(username);

        model.addAttribute("userProfile", userProfile);

        return "profile";
    }

}
