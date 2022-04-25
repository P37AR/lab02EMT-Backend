package mk.ukim.finki.labs.lab02emt.service;

import mk.ukim.finki.labs.lab02emt.model.Country;
import mk.ukim.finki.labs.lab02emt.model.dto.CountryDTO;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> findAllCountries();

    Optional<Country> findById(Long id);

    Optional<Country> findByName(String name);

    Country create(CountryDTO countryDTO);

    Boolean doesCountryExist(String name);
}
