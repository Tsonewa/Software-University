package com.example.exam.services.impl;

import com.example.exam.models.enitites.Album;
import com.example.exam.models.enitites.Artist;
import com.example.exam.models.enitites.enums.ArtistNameEnum;
import com.example.exam.models.enitites.service.AlbumAddServiceModel;
import com.example.exam.models.enitites.view.AlbumViewModel;
import com.example.exam.reps.AlbumRepository;
import com.example.exam.services.AlbumService;
import com.example.exam.services.ArtistService;
import com.example.exam.services.UserService;
import com.example.exam.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final ArtistService artistService;

    public AlbumServiceImpl(AlbumRepository albumRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, ArtistService artistService) {
        this.albumRepository = albumRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.artistService = artistService;
    }

    @Override
    public void addAlbum(AlbumAddServiceModel albumsAddServiceModel) {

        Album currAlbum = modelMapper.map(albumsAddServiceModel, Album.class);
        currAlbum.setAddedFrom(userService.findById(currentUser.getId()));
        Artist artistByName = artistService.findArtistByName(albumsAddServiceModel.getArtist());
        currAlbum.setArtist(artistByName);
        albumRepository.save(currAlbum);

    }

    @Override
    public List<AlbumViewModel> findAllAlbums() {
        return albumRepository.findAll().stream().map(a -> {

            AlbumViewModel map = modelMapper.map(a, AlbumViewModel.class);
            map.setArtist(a.getArtist().getName());

            return map;
        }).collect(Collectors.toList());
    }

    @Override
    public void deleteAlbum(Long id) {

        albumRepository.deleteById(id);
    }
}
