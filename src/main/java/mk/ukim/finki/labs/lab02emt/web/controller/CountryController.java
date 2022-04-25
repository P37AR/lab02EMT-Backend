package mk.ukim.finki.labs.lab02emt.web.controller;

import mk.ukim.finki.labs.lab02emt.model.Country;
import mk.ukim.finki.labs.lab02emt.model.dto.CountryDTO;
import mk.ukim.finki.labs.lab02emt.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getAllCountries() {
        return this.countryService.findAllCountries();
    }

    @PostMapping
    public Country createCountry(@RequestBody CountryDTO countryDTO) {
        return this.countryService.create(countryDTO);
    }
}
