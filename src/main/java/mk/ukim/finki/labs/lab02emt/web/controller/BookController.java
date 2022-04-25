package mk.ukim.finki.labs.lab02emt.web.controller;

import mk.ukim.finki.labs.lab02emt.model.Book;
import mk.ukim.finki.labs.lab02emt.model.dto.BookDTO;
import mk.ukim.finki.labs.lab02emt.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        this.bookService.deleteBook(id);
        return ResponseEntity.status(204).build();
    }

    @PostMapping
    public Book createBook(@RequestBody BookDTO bookDTO) {
        return this.bookService.createBook(bookDTO);
    }

    @GetMapping("/edit/{id}")
    public Book editBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        return this.bookService.editBook(id, bookDTO);
    }

    @GetMapping("/rent-book/{id}")
    public Book rentBook(@PathVariable Long id) {
        return this.bookService.rentBook(id);
    }
}
