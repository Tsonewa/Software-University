package springintro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import springintro.model.entity.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("Select a FROM Author a ORDER BY a.books.size DESC ")
    List<Author> findAllByBooksCountDesc();

    List<Author> findAllByFirstNameEndsWith(String string);
}
