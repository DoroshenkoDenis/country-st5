package guru.qa.country.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import guru.qa.country.data.CountryEntity;
import jakarta.annotation.Nonnull;

import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CountryJson(
        @JsonProperty("id")
        UUID id,
        @JsonProperty("name")
        String name,
        @JsonProperty("code")
        String code) implements ICountryJson {

    public static @Nonnull CountryJson fromEntity(@Nonnull CountryEntity entity) {
        return new CountryJson(
                entity.getId(),
                entity.getName(),
                entity.getCode()
        );
    }

    public CountryEntity toEntity() {
        return new CountryEntity(
                id(),
                name(),
                code());
    }

}