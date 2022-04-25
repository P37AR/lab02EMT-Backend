package mk.ukim.finki.labs.lab02emt.model.dto;

import lombok.Data;

@Data
public class CountryDTO {

    private Long id;

    private String name;

    private String continent;

    public CountryDTO() {}
}
