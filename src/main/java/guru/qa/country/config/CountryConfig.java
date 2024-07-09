package guru.qa.country.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;

public class CountryConfig {

    @Bean
    public ObjectMapper objectMapper() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(df);
        return mapper;
    }

}
