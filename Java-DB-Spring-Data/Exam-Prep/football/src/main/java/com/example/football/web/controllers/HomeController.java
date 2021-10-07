package com.example.football.web.controllers;

import com.example.football.service.PictureService;
import com.example.football.service.PlayerService;
import com.example.football.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController  extends BaseController{

    private final PictureService pictureService;
    private final TeamService teamService;
    private final PlayerService playerService;

    @Autowired
    public HomeController(PictureService pictureService, TeamService teamService, PlayerService playerService) {
        this.pictureService = pictureService;
        this.teamService = teamService;
        this.playerService = playerService;
    }

    @GetMapping("/")
    public ModelAndView index() {
        boolean areImported = this.playerService.areImported() &&
                this.pictureService.areImported() &&
                this.teamService.areImported();

        return super.view("index","areImported", areImported);
    }
}
