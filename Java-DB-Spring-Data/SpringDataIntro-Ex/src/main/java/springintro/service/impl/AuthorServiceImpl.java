package springintro.service.impl;

import org.springframework.stereotype.Service;
import springintro.model.entity.Author;
import springintro.model.entity.Book;
import springintro.repository.AuthorRepository;
import springintro.service.AuthorService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private static final String AUTHORS_FILE_PATH = "src/main/resources/files/authors.txt";
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (authorRepository.count() > 0) {
            return;
        }

        Files.readAllLines(Path.of(AUTHORS_FILE_PATH))
                .forEach(line -> {
                    String[] fullName = line.split("\\s+");
                    Author author = new Author(fullName[0], fullName[1]);

                    authorRepository.save(author);
                });

    }

    @Override
    public Author getRandomAuthor() {
        long randomId = ThreadLocalRandom.current().nextLong(1, authorRepository.count() + 1);

        return authorRepository.findById(randomId).orElse(null);
    }

    @Override
    public List<String> getAuthorsByBooksCount() {
        return authorRepository.findAllByBooksCountDesc()
                .stream()
                .map(author -> String.format("%s %s %d",
                        author.getFirstName(),
                        author.getLastName(),
                        author.getBooks().size()))
                .collect(Collectors.toList());
    }

    //TODO: 6
    @Override
    public List<String> findAuthorNamesEndingWith(String string) {
        return authorRepository.findAllByFirstNameEndsWith(string)
                .stream()
                .map(author -> String.format("%s %s", author.getFirstName(), author.getLastName()))
                .collect(Collectors.toList());
    }

    //TODO: 10
    @Override
    public List<String> findAuthorsAndTotalBookCopies() {
        return authorRepository
                .findAll()
                .stream()
                .map(author -> String.format("%s %s - %d",
                        author.getFirstName(), author.getLastName(),
                        author.getBooks().stream().map(Book::getCopies).reduce(Integer::sum).orElse(0)))
                .collect(Collectors.toList());
    }
}
