package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.Car;

import java.util.Set;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    //Extract from the database, the make, model, kilometers,
    // date of registration and count of pictures of all cars.
    // Order them first by pictures count in descending order then
    // by make alphabetically.

    @Query("SELECT c from Car c order by c.pictures.size desc, c.make")
    Set<Car> findAllByByPictureCountAndMake();

}
