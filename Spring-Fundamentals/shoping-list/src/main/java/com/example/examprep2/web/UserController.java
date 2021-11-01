package com.example.examprep2.web;

import com.example.examprep2.models.bidings.UserLoginBidingModel;
import com.example.examprep2.models.bidings.UserRegisterBindingModel;
import com.example.examprep2.models.service.UserLoginServiceModel;
import com.example.examprep2.models.service.UserRegisterServiceModel;
import com.example.examprep2.services.UserService;
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

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel(){
        return new UserRegisterBindingModel();
    }

    @GetMapping("/register")
    public String getRegister(){
        return "register";
    }

    @PostMapping("/register")
    public String registrateUser(@Valid UserRegisterBindingModel userRegisterBindingModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors() || !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())){

            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

            return "redirect:register";
        }

        userService.registrateUser(modelMapper.map(userRegisterBindingModel, UserRegisterServiceModel.class));

        return "redirect:login";
    }

    @GetMapping("/login")
    public String getLogin(Model model){

        if(!model.containsAttribute("isExist")) {
            model.addAttribute("isExist", true);
        }

        return "login";
    }

    @ModelAttribute
    public UserLoginBidingModel userLoginBidingModel(){
        return new UserLoginBidingModel();
    }


    @PostMapping("/login")
    public String loginUser(@Valid UserLoginBidingModel userLoginBidingModel,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){

            redirectAttributes.addFlashAttribute("userLoginBidingModel", userLoginBidingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBidingModel", bindingResult);

            return "redirect:login";
        }

        UserLoginServiceModel userByUsernameAndPassword = userService.findUserByUsernameAndPassword(userLoginBidingModel.getUsername(), userLoginBidingModel.getPassword());

        if (userByUsernameAndPassword == null){
        redirectAttributes.addFlashAttribute("userLoginBidingModel", userLoginBidingModel);
        redirectAttributes.addFlashAttribute("isExist", false);

        return "redirect:login";
    }

        userService.loginUser(userByUsernameAndPassword.getId(), userByUsernameAndPassword.getUsername());

        return "redirect:/";

    }

    @GetMapping("/logout")
    public String logout(){
        userService.logout();

        return "redirect:/";
    }

}


