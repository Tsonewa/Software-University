package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);


    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesIsLessThan(EditionType editionType, int copies);

    List<Book> findAllByPriceIsLessThanOrPriceGreaterThan(BigDecimal lowest, BigDecimal highest);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate before, LocalDate after);

    List<Book> findAllByTitleContaining(String word);

    List<Book> findAllByAuthorLastNameStartsWith(String beginning);

    @Query("SELECT count(b) FROM Book b WHERE length(b.title) > :length")
    int countAllByTitleGreaterThanNumber(@Param(value = "length") int length);

    @Query(value = "SELECT concat(a.first_name, ' ', a.last_name), sum(b.copies) " +
            " FROM books b " +
            " join authors  a ON b.author_id = a.id " +
            "group by b.author_id " +
            "order by sum(b.copies) DESC ", nativeQuery = true)
    List<Object[]> countAllByCopiesAndAuthorOrderDesc();


    List<Book> findAllByTitle(String title);
}
