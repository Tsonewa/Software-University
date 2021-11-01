package com.example.exam.reps;

import com.example.exam.models.enitites.Album;
import com.example.exam.models.enitites.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {


}
