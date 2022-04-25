package mk.ukim.finki.labs.lab02emt.model.dto;

import lombok.Data;
import mk.ukim.finki.labs.lab02emt.model.Country;

@Data
public class AuthorDTO {

    private Long id;

    private String name;

    private String surname;

    private Country country;

    public AuthorDTO(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
}
