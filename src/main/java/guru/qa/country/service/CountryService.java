package guru.qa.country.service;

import guru.qa.country.data.CountryEntity;
import guru.qa.country.data.CountryRepository;
import guru.qa.country.model.CountryJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<CountryJson> allCountries() {
        return countryRepository.findAll()
                .stream()
                .map(CountryJson::fromEntity)
                .collect(Collectors.toList());
    }

    public CountryJson addCountry(CountryJson country) {
        return CountryJson.fromEntity(countryRepository.save(country.toEntity()));
    }

    public CountryJson editCountryName(UUID id, @NonNull CountryJson country) {
        CountryEntity countryEntity =
                countryRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Country not found"));

        countryEntity.setName(country.name());
        return CountryJson.fromEntity(countryRepository.save(countryEntity));
    }

}
