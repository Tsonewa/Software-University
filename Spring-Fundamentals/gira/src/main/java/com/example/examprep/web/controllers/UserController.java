package com.example.examprep.web.controllers;

import com.example.examprep.models.enitites.bindings.UserLoginBidingModel;
import com.example.examprep.models.enitites.bindings.UserRegisterBindingModel;
import com.example.examprep.models.enitites.service.UserLoginServiceModel;
import com.example.examprep.models.enitites.service.UserRegisterServiceModel;
import com.example.examprep.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
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

    @GetMapping("/register")
    public String getRegister(Model model){

        if(!model.containsAttribute("isExist")){
            model.addAttribute("isExist", false);
        }
            return "register";
        }

        @ModelAttribute
        public UserRegisterBindingModel createRegisterUser(){
        return new UserRegisterBindingModel();

        }

        @PostMapping("/register")
        public String registrarUser(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes){

            if (bindingResult.hasErrors() || !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())){

                redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
                redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

                return "redirect:register";
            }

            if(userService.findUserByEmail(userRegisterBindingModel.getEmail()) != null){
                redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
                redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
                redirectAttributes.addAttribute("isExist", true);

                return "redirect:register";

            }

         userService.registateUser(modelMapper.map(userRegisterBindingModel, UserRegisterServiceModel.class));

            return "redirect:login";
        }

        @ModelAttribute
        public UserLoginBidingModel userLoginBidingModel(){
        return new UserLoginBidingModel();
        }

@PostMapping("/login")
public String logUser(@Valid UserLoginBidingModel userLoginBidingModel,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userLoginBidingModel", userLoginBidingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBidingModel", bindingResult);

            return "redirect:login";
        }

    UserLoginServiceModel userByEmailAndPassword =
            userService.findUserByEmailAndPassword(
                    userLoginBidingModel.getEmail(), userLoginBidingModel.getPassword());

    if (userByEmailAndPassword == null){
        redirectAttributes.addFlashAttribute("userLoginBidingModel", userLoginBidingModel);
        redirectAttributes.addFlashAttribute("isExist", false);

        return "redirect:login";
    }

        userService.loginUser(userByEmailAndPassword.getId(), userByEmailAndPassword.getUsername());
        return "redirect:/";

}

    @GetMapping("/login")
    public String getLogin(Model model){

        if(!model.containsAttribute("isExist")) {
            model.addAttribute("isExist", true);
        }
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {

        userService.logout();

        return "index";
    }
    }
