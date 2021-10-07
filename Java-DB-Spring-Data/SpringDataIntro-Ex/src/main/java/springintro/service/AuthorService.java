package springintro.service;

import springintro.model.entity.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {

    void seedAuthors() throws IOException;
    Author getRandomAuthor();

    List<String> getAuthorsByBooksCount();

    List<String> findAuthorNamesEndingWith(String string);

    List<String> findAuthorsAndTotalBookCopies();
}
