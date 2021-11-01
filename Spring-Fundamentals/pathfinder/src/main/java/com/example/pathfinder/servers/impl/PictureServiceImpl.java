package com.example.pathfinder.servers.impl;

import com.example.pathfinder.repos.PictureRepository;
import com.example.pathfinder.servers.PictureService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;

    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public List<String> findAllPictureUrls() {
        return pictureRepository.findAllUrls();
    }
}
