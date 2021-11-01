package com.example.exam.web.controllers;

import com.example.exam.models.enitites.bindings.AlbumsAddBindingModel;
import com.example.exam.models.enitites.service.AlbumAddServiceModel;
import com.example.exam.services.AlbumService;
import com.example.exam.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/albums")
public class AlbumsController {

    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final AlbumService albumService;

    public AlbumsController(ModelMapper modelMapper, CurrentUser currentUser, AlbumService albumService) {
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.albumService = albumService;
    }


    @GetMapping("/add")
    public String getAlbum(){

        return "add-album";
    }

    @ModelAttribute
    public AlbumsAddBindingModel albumsAddBindingModel(){
        return new AlbumsAddBindingModel();
    }

    @PostMapping("/add")
    public String addAlbum(@Valid AlbumsAddBindingModel albumsAddBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){

            redirectAttributes.addFlashAttribute("albumsAddBindingModel", albumsAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.albumsAddBindingModel", bindingResult);

        return "redirect:add";
        }

        albumService.addAlbum(modelMapper.map(albumsAddBindingModel, AlbumAddServiceModel.class));

        return "/home";

    }

    @GetMapping("/delete/{id}")
    public String deleteAlbum(@PathVariable Long id){

        albumService.deleteAlbum(id);

        return "redirect:/";
    }



}
