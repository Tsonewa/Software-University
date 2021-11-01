package com.example.exam.services;

import com.example.exam.models.enitites.service.AlbumAddServiceModel;
import com.example.exam.models.enitites.view.AlbumViewModel;

import java.util.List;

public interface AlbumService {
    void addAlbum(AlbumAddServiceModel albumAddServiceModel);

    List<AlbumViewModel> findAllAlbums();

    void deleteAlbum(Long id);
}



