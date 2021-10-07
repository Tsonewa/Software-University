package springintro.service.impl;

import org.springframework.stereotype.Service;
import springintro.model.entity.Author;
import springintro.model.entity.Book;
import springintro.model.entity.Category;
import springintro.model.enumeration.AgeRestriction;
import springintro.model.enumeration.EditionType;
import springintro.repository.BookRepository;
import springintro.service.BookService;
import springintro.service.CategoryService;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorServiceImpl authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorServiceImpl authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files.readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(line -> {
                    String[] bookData = line.split("\\s+");
                    Book book = createBookByData(bookData);
                    bookRepository.save(book);

                });


    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {
        return bookRepository.findAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }

    @Override
    public List<String> findAuthorsByBookReleaseDateBefore(int year) {
        return bookRepository.findAllByReleaseDateBefore(LocalDate.of(year, 1, 1))
                .stream()
                .map(book -> book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName())
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksWithGivenAuthor(String firstName, String lastName) {
        return bookRepository
                .findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(firstName, lastName)
                .stream()
                .map(book -> String.format("%s %s %d", book.getTitle(),
                        book.getReleaseDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        book.getCopies()))
                .collect(Collectors.toList());

    }

    //TODO: 1
    @Override
    public List<String> findAllTitlesWithGivenAgeRestriction(String ageRestriction) {
        return bookRepository.findAllByAgeRestriction(AgeRestriction.valueOf(ageRestriction.toUpperCase()))
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());

    }

    //TODO: 2
    @Override
    public List<String> findALlTitlesByEditionTypeAndCopies() {
        final EditionType et = EditionType.GOLD;
        final int copies = 5000;

        return bookRepository.findAllByEditionTypeAndCopiesLessThan(et, copies)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    //TODO: 3
    @Override
    public List<String> findAllBooksByPrice() {
        final BigDecimal FIRST_PRICE = BigDecimal.valueOf(5);
        final BigDecimal SECOND_PRICE = BigDecimal.valueOf(40);

        return bookRepository.findAllByPriceLessThanOrPriceGreaterThan(FIRST_PRICE, SECOND_PRICE)
                .stream()
                .map(book -> String.format("%s - $%.2f", book.getTitle(), book.getPrice()))
                .collect(Collectors.toList());
    }

    //TODO: 4
    @Override
    public List<String> findAllBookTitlesNotReleasedIn(int year) {
        return bookRepository.findAllByReleaseDateYearNotInYear(String.valueOf(year))
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    //TODO: 5
    @Override
    public List<String> findAllBookTitlesReleasedBefore(LocalDate releaseDate) {
        return bookRepository.findAllByReleaseDateBefore(releaseDate)
                .stream()
                .map(book -> String.format("%s %s %.2f",
                        book.getTitle(), book.getEditionType().name(), book.getPrice()))
                .collect(Collectors.toList());
    }

    //TODO: 7
    @Override
    public List<String> findAllBookTitlesContainingString(String string) {
        return bookRepository.findAllByTitleContains(string)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    //TODO: 8
    @Override
    public List<String> findAllBookTitlesWithAuthorLastNameStartsWith(String lastName) {
        return bookRepository.findAllByAuthorLastNameStartsWith(lastName)
                .stream()
                .map(book -> String.format("%s (%s %s)",
                        book.getTitle(),
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .collect(Collectors.toList());
    }

    //TODO: 9
    @Override
    public int findCountOfBooksWithTitleLongerThan(int length) {
        return bookRepository.findAllByTitleLengthGreaterThan(length)
                .size();
    }

    //TODO: 11
    @Override
    public List<String> findAllBookInfoByTitle(String title) {
        return bookRepository.findAllByTitle(title)
                .stream()
                .map(book -> String.format("%s %s %s %.2f",
                        book.getTitle(),
                        book.getEditionType().name(),
                        book.getAgeRestriction().name(),
                        book.getPrice()))
                .collect(Collectors.toList());
    }

    private Book createBookByData(String[] bookData) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookData[0])];
        LocalDate releaseDate = LocalDate.parse(bookData[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        int copies = Integer.parseInt(bookData[2]);
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(bookData[3]));
        AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(bookData[4])];
        String title = Arrays.stream(bookData).skip(5).collect(Collectors.joining(" "));
        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService.getRandomCategories();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);


    }
}
