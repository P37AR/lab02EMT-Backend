package mk.ukim.finki.labs.lab02emt.model.dto;

import lombok.Data;
import mk.ukim.finki.labs.lab02emt.model.Author;
import mk.ukim.finki.labs.lab02emt.model.enumerations.Category;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class BookDTO {

    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    private Integer availableCopies;

    private Author author;

    public BookDTO(String name, Category category, Integer availableCopies, Author author) {
        this.name=name;
        this.category = category;
        this.availableCopies = availableCopies;
        this.author = author;
    }
}
