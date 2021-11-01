package com.example.pathfinder.web;

import com.example.pathfinder.servers.PictureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final PictureService pictureService;

    public HomeController(PictureService pictureService) {
        this.pictureService = pictureService;
    }


    @GetMapping("/")
    public String populatePictures(Model model){

        model.addAttribute("pictures",
                pictureService.findAllPictureUrls());

        return "index";
    }



    @GetMapping("/about")
    public String about(){

        return "about";
    }


}
