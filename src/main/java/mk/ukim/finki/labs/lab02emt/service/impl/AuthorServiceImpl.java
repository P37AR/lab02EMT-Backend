package mk.ukim.finki.labs.lab02emt.service.impl;

import mk.ukim.finki.labs.lab02emt.model.Author;
import mk.ukim.finki.labs.lab02emt.model.dto.AuthorDTO;
import mk.ukim.finki.labs.lab02emt.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.labs.lab02emt.repository.AuthorRepository;
import mk.ukim.finki.labs.lab02emt.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {


    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author createAuthor(AuthorDTO authorDTO) {
        Author author=new Author();
        author.setName(authorDTO.getName());
        author.setSurname(authorDTO.getSurname());
        author.setCountry(authorDTO.getCountry());
        return this.authorRepository.save(author);
    }

    @Override
    public Author editAuthor(Long id, AuthorDTO authorDTO) {
        Optional<Author> author=this.authorRepository.findById(id);
        if(author.isPresent()) {
            Author toEdit=author.get();
            toEdit.setName(authorDTO.getName());
            toEdit.setSurname(authorDTO.getSurname());
            toEdit.setCountry(authorDTO.getCountry());
            return this.authorRepository.save(toEdit);
        }
        throw new AuthorNotFoundException(id);
    }

    @Override
    public Boolean doesAuthorExist(String name) {
        return this.authorRepository.findByName(name).isPresent();
    }
}
