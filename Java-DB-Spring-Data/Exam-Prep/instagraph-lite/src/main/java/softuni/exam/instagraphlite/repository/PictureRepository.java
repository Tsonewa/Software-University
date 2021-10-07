package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.Picture;

import java.util.Set;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {

    boolean existsByPath(String path);

    Picture findByPath(String path);

    Set<Picture> findAllBySizeGreaterThanOrderBySize(Double size);


}
