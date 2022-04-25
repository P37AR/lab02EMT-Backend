package mk.ukim.finki.labs.lab02emt.service;

import mk.ukim.finki.labs.lab02emt.model.Author;
import mk.ukim.finki.labs.lab02emt.model.dto.AuthorDTO;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> findAll();

    Author createAuthor(AuthorDTO authorDTO);

    Author editAuthor(Long id, AuthorDTO authorDTO);

    Boolean doesAuthorExist(String name);
}
