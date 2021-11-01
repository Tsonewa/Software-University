package com.example.exam.web.controllers;

import com.example.exam.models.enitites.view.AlbumViewModel;
import com.example.exam.services.AlbumService;
import com.example.exam.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;
    private final AlbumService albumService;

    public HomeController(CurrentUser currentUser, ModelMapper modelMapper, AlbumService albumService) {
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
        this.albumService = albumService;
    }

    @GetMapping("/")
    public String index(Model model){

        if(currentUser.getId() == null){
            return "index";
        }

        List<AlbumViewModel> allAlbums = albumService.findAllAlbums();
        model.addAttribute("albums",allAlbums);
        model.addAttribute("totalCopies", allAlbums
                .stream()
                .map(AlbumViewModel::getCopies)
                .reduce(Integer::sum)
                .orElse(0));

        return "home";

    }
}
