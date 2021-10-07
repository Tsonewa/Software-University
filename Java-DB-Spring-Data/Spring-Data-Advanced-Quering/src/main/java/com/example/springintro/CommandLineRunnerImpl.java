package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader bufferedReader;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService, BufferedReader bufferedReader) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
        //printAllBooksAfterYear(2000);
        //printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
        //printAllAuthorsAndNumberOfTheirBooks();
        //pritnALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");

        while (true) {
            System.out.println("Examine exercise #: ");
            int num = Integer.parseInt(bufferedReader.readLine());
            switch (num) {
                case 1:
                    System.out.println("Enter age restriction (MINOR, TEEN, ADULT): ");
                    AgeRestriction ageRestriction = AgeRestriction.valueOf(bufferedReader.readLine().toUpperCase());
                    bboksTitlesByAgeRestriction(ageRestriction);
                    break;
                case 2:
                    // with parameters

//                    System.out.println("Enter Edition type ( NORMAL, PROMO, GOLD): ");
//                    EditionType edType = EditionType.valueOf(bufferedReader.readLine());
//                    System.out.println("Enter copies: ");
//                    int copiesNumber = Integer.parseInt(bufferedReader.readLine());
//                    goldenBooks(edType, copiesNumber);

                    // w/o parameters
                    goldenBooksWoParams();
                    break;

                case 3:
                    // with parameters

//                    System.out.println("Enter lowest price: ");
//                    BigDecimal price1 = new BigDecimal(bufferedReader.readLine());
//                    System.out.println("Enter highest price: ");
//                    BigDecimal price2 = new BigDecimal(bufferedReader.readLine());
//                    booksByPrice(price1, price2);

                    // w/o parameters
                    booksByPriceLowerThan5AndHigherThan40();
                    break;

                case 4:
                    System.out.println("Enter year: ");
                    int year = Integer.parseInt(bufferedReader.readLine());
                    notReleasedBooks(year);
                    break;
                case 5:
                    System.out.println("Enter date in the format dd-MM-yyyy: ");
                    LocalDate date = LocalDate.parse(bufferedReader.readLine(), DateTimeFormatter.ofPattern("dd-MM-yyy"));
                    booksReleasedBeforeDate(date);
                    break;
                case 6:
                    System.out.println("Enter ending of author's name: ");
                    String ending = bufferedReader.readLine();
                    authorsSearch(ending);
                    System.out.printf("\tCheck results manually in DB, because we insert random Authors for every books.%n");
                    break;

                case 7:
                    System.out.println("Enter word / part of word to search for book title: ");
                    String word = bufferedReader.readLine();
                    bookSearch(word);
                    break;

                case 8:
                    System.out.println("Enter beginning of an author last name: ");
                    String beginning = bufferedReader.readLine();
                    BookTitlesSearch(beginning);
                    break;

                case 9:
                    System.out.println("Enter title length: ");
                    int length = Integer.parseInt(bufferedReader.readLine());
                    countBooks(length);
                    break;

                case 10:
                    totalBookCopies();
                    break;

                case 11:
                    System.out.println("Enter book title: ");
                    String title = bufferedReader.readLine();
                    reducedBook(title);
                    break;
                default:
                    System.out.println("No exercise with that number.");

            }
            System.out.printf("Do you want to examine another exercise ? %n\tIf yes - press y  %n\tIf no press any key%n");
            String decision = bufferedReader.readLine();
            if (!decision.equals("y")) {
                System.out.println("Thank you for the time !");
                return;
            }
        }
    }

    private void reducedBook(String title) {
        this.bookService
                .findAllByTitle(title)
                .forEach(System.out::println);

    }

    private void totalBookCopies() {
        this.bookService
                .countAllByCopiesAndAuthorOrderDesc()
                .forEach(System.out::println);

    }

    private void countBooks(int length) {
        System.out.println(this.bookService.countAllByTitleGreaterThanNumber(length));
    }

    private void BookTitlesSearch(String beginning) {

        this.bookService
                .findAllByAuthorLastNameStartsWith(beginning)
                .forEach(System.out::println);

    }

    private void bookSearch(String word) {
        this.bookService
                .findAllByTitleContaining(word)
                .forEach(System.out::println);
    }

    private void authorsSearch(String ending) {
        this.authorService
                .findAllByFirstNameEndsWith(ending)
                .forEach(System.out::println);
    }

    private void booksReleasedBeforeDate(LocalDate date) {
        this.bookService
                .findAllByReleaseDateBeforeLd(date)
                .forEach(System.out::println);
    }


    private void booksByPriceLowerThan5AndHigherThan40() {
        this.bookService
                .booksByPriceLowerThan5AndHigherThan40()
                .forEach(System.out::println);
    }

    private void booksByPrice(BigDecimal price1, BigDecimal price2) {
        this.bookService
                .findAllByPriceIsLessThanOrPriceGreaterThan(price1, price2)
                .forEach(b -> System.out.printf("%s - $%.2f%n",
                        b.getTitle(), b.getPrice()));
    }

    private void goldenBooksWoParams() {
        this.bookService
                .findAllByEditionTypeGoldAndCopiesIsLessThan5000()
                .forEach(System.out::println);
    }

    private void goldenBooks(EditionType edType, int copiesNumber) {
        this.bookService
                .findAllByEditionTypeAndCopiesIsLessThan(edType, copiesNumber)
                .forEach(b -> System.out.println(b.getTitle()));
    }

    private void notReleasedBooks(int year) {
        this.bookService
                .findAllByReleaseDateBeforeOrReleaseDateAfter(year)
                .forEach(System.out::println);
    }

    private void bboksTitlesByAgeRestriction(AgeRestriction ageRestriction) {
        this.bookService
                .findAllByAgeRestriction(ageRestriction)
                .forEach(b -> System.out.println(b.getTitle()));
    }


    //old
    private void pritnALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {

        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
