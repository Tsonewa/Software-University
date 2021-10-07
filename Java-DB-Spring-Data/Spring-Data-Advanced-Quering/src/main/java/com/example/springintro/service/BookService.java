package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);


    //hw
    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesIsLessThan(EditionType editionType, int copies);

    List<String> findAllByEditionTypeGoldAndCopiesIsLessThan5000();

    List<Book> findAllByPriceIsLessThanOrPriceGreaterThan(BigDecimal lowest, BigDecimal highest);

    List<String> booksByPriceLowerThan5AndHigherThan40();


    List<String> findAllByReleaseDateBeforeOrReleaseDateAfter(int year);

    List<String> findAllByReleaseDateBeforeLd(LocalDate date);

    List<String> findAllByTitleContaining(String word);

    List<String> findAllByAuthorLastNameStartsWith(String beginning);

    int countAllByTitleGreaterThanNumber(int length);

    List<String> countAllByCopiesAndAuthorOrderDesc();

    List<String> findAllByTitle(String title);

}
