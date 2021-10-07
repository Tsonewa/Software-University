package springintro.service;

import springintro.model.entity.Book;
import springintro.model.enumeration.AgeRestriction;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {

    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAuthorsByBookReleaseDateBefore(int year);

    List<String> findAllBooksWithGivenAuthor(String firstName, String lastName);

    List<String> findAllTitlesWithGivenAgeRestriction(String ageRestriction);

    List<String> findALlTitlesByEditionTypeAndCopies();

    List<String> findAllBooksByPrice();

    List<String> findAllBookTitlesNotReleasedIn(int year);

    List<String> findAllBookTitlesReleasedBefore(LocalDate releaseDate);

    List<String> findAllBookTitlesContainingString(String string);

    List<String> findAllBookTitlesWithAuthorLastNameStartsWith(String lastName);

    int findCountOfBooksWithTitleLongerThan(int length);

    List<String> findAllBookInfoByTitle(String title);

}
