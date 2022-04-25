package mk.ukim.finki.labs.lab02emt.service;

import mk.ukim.finki.labs.lab02emt.model.Author;
import mk.ukim.finki.labs.lab02emt.model.Book;
import mk.ukim.finki.labs.lab02emt.model.dto.BookDTO;

import java.util.List;


public interface BookService {

    List<Book> getAllBooks();

    Book createBook(BookDTO bookDTO);

    Book editBook(Long id, BookDTO bookDTO);

    Book rentBook(Long id);

    void deleteBook(Long id);

    Boolean doesBookExist(Author author);
}
