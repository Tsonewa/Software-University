package springintro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import springintro.model.entity.Book;
import springintro.model.enumeration.AgeRestriction;
import springintro.model.enumeration.EditionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDate);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDate);

    List<Book> findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lower, BigDecimal upper);

    @Query("SELECT b FROM Book b WHERE substring(b.releaseDate, 1, 4) NOT IN :year")
    List<Book> findAllByReleaseDateYearNotInYear(String year);

    List<Book> findAllByTitleContains(String string);

    List<Book> findAllByAuthorLastNameStartsWith(String lastName);

    @Query("SELECT b FROM Book b WHERE LENGTH(b.title) > :length")
    List<Book> findAllByTitleLengthGreaterThan(int length);

    List<Book> findAllByTitle(String title);


}

