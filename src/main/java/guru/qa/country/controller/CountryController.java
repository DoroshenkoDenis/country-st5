package guru.qa.country.controller;

import guru.qa.country.model.CountryJson;
import guru.qa.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/all")
    public List<CountryJson> allCountries() {
        return countryService.allCountries();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CountryJson addCountry(@RequestBody CountryJson country) {
        return countryService.addCountry(country);
    }

    @PatchMapping("/edit/{id}")
    public CountryJson editCountry(@PathVariable UUID id, @RequestBody CountryJson country) {
        return countryService.editCountryName(id, country);
    }
}
