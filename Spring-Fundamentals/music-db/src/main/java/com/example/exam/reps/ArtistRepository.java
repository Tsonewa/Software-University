package com.example.exam.reps;

import com.example.exam.models.enitites.Artist;
import com.example.exam.models.enitites.enums.ArtistNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    Artist findByName(ArtistNameEnum name);
}
