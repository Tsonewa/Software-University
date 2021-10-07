package springintro;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springintro.model.entity.Book;
import springintro.service.AuthorService;
import springintro.service.BookService;
import springintro.service.CategoryService;

import java.io.BufferedReader;
import java.io.IOException;
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
        //TODO: IGNORE - OLD EXERCISE TASKS
     //  categoryService.seedCategories();
      //  authorService.seedAuthors();
       // bookService.seedBooks();

//        ex_01();

//        ex_02();

//        ex_03();

//        ex_04();

        //TODO: NEW EXERCISE TASKS
        System.out.println("Enter exercise number:");
        int n = Integer.parseInt(bufferedReader.readLine());

        switch (n) {
            case 1:
                titlesByAgeRestriction_01();
                break;
            case 2:
                goldenBooks_02();
                break;
            case 3:
                booksByPrice_03();
                break;
            case 4:
                notReleasedBooks_04();
                break;
            case 5:
                booksReleasedBeforeDate_05();
                break;
            case 6:
                authorsSearch_06();
                break;
            case 7:
                booksSearch_07();
                break;
            case 8:
                bookTitlesSearch_08();
                break;
            case 9:
                countBooks_09();
                break;
            case 10:
                totalBookCopies_10();
                break;
            case 11:
                reducedBook_11();
                break;

        }


    }

    private void reducedBook_11() throws IOException {
        System.out.println("Please enter book title:");
        String title = bufferedReader.readLine();

        bookService.findAllBookInfoByTitle(title)
                .forEach(System.out::println);
    }

    private void totalBookCopies_10() {
        authorService.findAuthorsAndTotalBookCopies()
                .forEach(System.out::println);
    }

    private void countBooks_09() throws IOException {
        System.out.println("Please enter a number:");
        int length = Integer.parseInt(bufferedReader.readLine());

        System.out.println(bookService.findCountOfBooksWithTitleLongerThan(length));
    }

    private void bookTitlesSearch_08() throws IOException {
        System.out.println("Please enter a string:");
        String lastName = bufferedReader.readLine();

        bookService.findAllBookTitlesWithAuthorLastNameStartsWith(lastName)
                .forEach(System.out::println);
    }

    private void booksSearch_07() throws IOException {
        System.out.println("Please enter a string:");
        String string = bufferedReader.readLine();

        bookService.findAllBookTitlesContainingString(string)
                .forEach(System.out::println);
    }

    private void authorsSearch_06() throws IOException {
        System.out.println("Please enter a string:");
        String string = bufferedReader.readLine();

        authorService.findAuthorNamesEndingWith(string)
                .forEach(System.out::println);
    }

    private void booksReleasedBeforeDate_05() throws IOException {
        System.out.println("Please enter a date in the format dd-MM-yyyy:");
        LocalDate releaseDate = LocalDate.parse(bufferedReader.readLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        bookService.findAllBookTitlesReleasedBefore(releaseDate)
                .forEach(System.out::println);


    }

    private void notReleasedBooks_04() throws IOException {
        System.out.println("Please enter a year:");
        int year = Integer.parseInt(bufferedReader.readLine());

        bookService.findAllBookTitlesNotReleasedIn(year)
                .forEach(System.out::println);

    }

    private void booksByPrice_03() {
        bookService.findAllBooksByPrice()
                .forEach(System.out::println);
    }

    private void goldenBooks_02() {
        bookService.findALlTitlesByEditionTypeAndCopies()
                .forEach(System.out::println);
    }

    private void titlesByAgeRestriction_01() throws IOException {
        System.out.println("Please enter age restriction:");
        String ageRestriction = bufferedReader.readLine();

        bookService.findAllTitlesWithGivenAgeRestriction(ageRestriction)
                .forEach(System.out::println);

    }


    private void ex_04() {
        bookService.findAllBooksWithGivenAuthor("George", "Powell")
                .forEach(System.out::println);
    }

    private void ex_03() {
        authorService.getAuthorsByBooksCount()
                .forEach(System.out::println);
    }

    private void ex_02() {
        final int YEAR = 1990;

        bookService.findAuthorsByBookReleaseDateBefore(YEAR)
                .forEach(System.out::println);
    }

    private void ex_01() {
        final int YEAR = 2000;

        bookService.findAllBooksAfterYear(YEAR)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }
}
