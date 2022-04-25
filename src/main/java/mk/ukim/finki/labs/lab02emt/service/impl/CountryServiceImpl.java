package mk.ukim.finki.labs.lab02emt.service.impl;

import mk.ukim.finki.labs.lab02emt.model.Country;
import mk.ukim.finki.labs.lab02emt.model.dto.CountryDTO;
import mk.ukim.finki.labs.lab02emt.repository.CountryRepository;
import mk.ukim.finki.labs.lab02emt.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAllCountries() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public Optional<Country> findByName(String name) {
        return this.countryRepository.findByName(name);
    }

    @Override
    public Country create(CountryDTO countryDTO) {
        Country country=new Country();
        country.setName(countryDTO.getName());
        country.setContinent(countryDTO.getContinent());
        return countryRepository.save(country);
    }

    @Override
    public Boolean doesCountryExist(String name) {
        return this.countryRepository.findByName(name).isPresent();
    }
}
