package com.example.football.repository;

import com.example.football.domain.entities.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {

    boolean existsByUrl(String url);

    Picture getPictureByUrl(String url);

}
