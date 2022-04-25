package mk.ukim.finki.labs.lab02emt.config;

import mk.ukim.finki.labs.lab02emt.model.Author;
import mk.ukim.finki.labs.lab02emt.model.Country;
import mk.ukim.finki.labs.lab02emt.model.dto.AuthorDTO;
import mk.ukim.finki.labs.lab02emt.model.dto.BookDTO;
import mk.ukim.finki.labs.lab02emt.model.dto.CountryDTO;
import mk.ukim.finki.labs.lab02emt.model.enumerations.Category;
import mk.ukim.finki.labs.lab02emt.service.AuthorService;
import mk.ukim.finki.labs.lab02emt.service.BookService;
import mk.ukim.finki.labs.lab02emt.service.CategoryService;
import mk.ukim.finki.labs.lab02emt.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class DataInitializer {

    private final BookService bookService;
    private final CategoryService categoryService;
    private final CountryService countryService;
    private final AuthorService authorService;

    public DataInitializer(BookService bookService, CategoryService categoryService, CountryService countryService, AuthorService authorService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.countryService = countryService;
        this.authorService = authorService;
    }

    public void createCountries() {
        for(String item: Arrays.asList("Test", "Test1", "Test2")) {
            if (!this.countryService.doesCountryExist(item)) {
                CountryDTO countryDTO = new CountryDTO();
                countryDTO.setName(item);
                countryDTO.setContinent(item);
                this.countryService.create(countryDTO);
            }
        }
    }

    public void createAuthors() {
        for(Country country: this.countryService.findAllCountries()) {
            for(String item: Arrays.asList("Test", "Test1", "Test2")) {
                if (!this.authorService.doesAuthorExist(item)) {
                    AuthorDTO authorDTO = new AuthorDTO(item, item, country);
                    this.authorService.createAuthor(authorDTO);
                }
            }
        }
    }

    public void createBooks() {
        for(Author author: this.authorService.findAll()) {
            for(Category category: this.categoryService.getAllCategories()) {
                if(!this.bookService.doesBookExist(author)) {
                    BookDTO bookDTO = new BookDTO("Test", category, 3, author);
                    this.bookService.createBook(bookDTO);
                }
            }
        }
    }

    @PostConstruct
    public void initData() {
        createCountries();
        createAuthors();
        createBooks();
    }
}