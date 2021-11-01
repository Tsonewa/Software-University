package com.example.pathfinder.web;

import com.example.pathfinder.models.enums.Level;
import com.example.pathfinder.models.enums.RoleEnum;
import com.example.pathfinder.models.enums.bidings.UserLoginBidingModel;
import com.example.pathfinder.models.enums.bidings.UserRegisterBidingModel;
import com.example.pathfinder.models.enums.entities.Role;
import com.example.pathfinder.models.enums.service.UserLoginServiceModel;
import com.example.pathfinder.models.enums.service.UserRegisterServiceModel;
import com.example.pathfinder.servers.UserService;
import com.example.pathfinder.utils.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Set;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserController(UserService userService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @ModelAttribute("user")
    public UserRegisterBidingModel userRegisterBidingModel(){
        return new UserRegisterBidingModel();
    }

    @ModelAttribute("newUser")
    public UserLoginBidingModel userLoginBidingModel(){
        return new UserLoginBidingModel();
    }

    @GetMapping("/register")
    public String getRegister(){

        return "register";
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        model.addAttribute("isExist", false);
        return "login";
    }

    @PostMapping("/register")
    public String registerUser(@Valid UserRegisterBidingModel userRegisterBidingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors() ||
                !userRegisterBidingModel.getPassword()
                        .equals(userRegisterBidingModel.getConfirmPassword())){
            //Passwords doest match or invalid data was filled in the form

            redirectAttributes.addFlashAttribute("userRegisterBidingModel", userRegisterBidingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BidingResult.userRegisterBidingModel", bindingResult);
          //  userService.userExist(userRegisterBidingModel);

            return "redirect:register";

        }

        UserRegisterServiceModel newUser
                = modelMapper.map(userRegisterBidingModel,
                            UserRegisterServiceModel.class);

        newUser.setLevel(Level.BEGINNER);
        Role role = new Role();
        role.setRole(RoleEnum.USER);
        newUser.setRole(Set.of(role));

        userService.registrateUser(newUser);

        return "redirect:login";

    }

    @PostMapping("/login")
    public String loginUser(@Valid UserLoginBidingModel userLoginBidingModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes){


        if (bindingResult.hasErrors()){

            redirectAttributes.addFlashAttribute("userLoginBidingModel",userLoginBidingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BidingResult.userRegisterBidingModel", bindingResult);

            return "redirect:login";

        }

        UserLoginServiceModel user = modelMapper.map(userLoginBidingModel, UserLoginServiceModel.class);

        if(userService.userExist(user.getUsername(), user.getPassword()) == null){

            redirectAttributes.addFlashAttribute("userLoginBidingModel",userLoginBidingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BidingResult.userRegisterBidingModel", bindingResult);
            redirectAttributes.addFlashAttribute("isExist", true);

        return "redirect:login";
        }

      userService.loginUser(user);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logoutUser(){
        currentUser.clear();

        return "redirect:/";
    }
}
