package mk.ukim.finki.labs.lab02emt.service.impl;

import mk.ukim.finki.labs.lab02emt.model.Author;
import mk.ukim.finki.labs.lab02emt.model.Book;
import mk.ukim.finki.labs.lab02emt.model.dto.BookDTO;
import mk.ukim.finki.labs.lab02emt.model.exceptions.BookNotFoundException;
import mk.ukim.finki.labs.lab02emt.model.exceptions.NoBooksLeftException;
import mk.ukim.finki.labs.lab02emt.repository.BookRepository;
import mk.ukim.finki.labs.lab02emt.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book createBook(BookDTO bookDTO) {
        Book book=new Book();
        book.setName(bookDTO.getName());
        book.setCategory(bookDTO.getCategory());
        book.setAvailableCopies(bookDTO.getAvailableCopies());
        book.setAuthor(bookDTO.getAuthor());
        return this.bookRepository.save(book);
    }

    @Override
    public Book editBook(Long id, BookDTO bookDTO) {
        Optional<Book> book=this.bookRepository.findById(id);
        if(book.isPresent()) {
            Book toEdit=book.get();
            toEdit.setName(bookDTO.getName());
            toEdit.setCategory(bookDTO.getCategory());
            toEdit.setAvailableCopies(bookDTO.getAvailableCopies());
            toEdit.setAuthor(bookDTO.getAuthor());
            return this.bookRepository.save(toEdit);
        }
        throw new BookNotFoundException(id);
    }

    @Override
    public Book rentBook(Long id) {
        Optional<Book> book=this.bookRepository.findById(id);
        if(book.isPresent()) {
            if(book.get().getAvailableCopies()>0) {
                book.get().setAvailableCopies(book.get().getAvailableCopies()-1);
            }
            else
                throw new NoBooksLeftException();
        }
        throw new BookNotFoundException(id);
    }

    @Override
    public void deleteBook(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Boolean doesBookExist(Author author) {
        return this.bookRepository.findByAuthor(author).isPresent();
    }
}
