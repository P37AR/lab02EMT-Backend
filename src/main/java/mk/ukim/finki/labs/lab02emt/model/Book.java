package mk.ukim.finki.labs.lab02emt.model;

import lombok.Data;
import mk.ukim.finki.labs.lab02emt.model.enumerations.Category;

import javax.persistence.*;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    private int availableCopies;

    @ManyToOne
    private Author author;

    public Book() {}

    public Book(String name, Category category, int availableCopies, Author author) {
        this.name = name;
        this.category = category;
        this.availableCopies = availableCopies;
        this.author = author;
    }
}
