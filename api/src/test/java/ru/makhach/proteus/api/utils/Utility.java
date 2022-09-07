package ru.makhach.proteus.api.utils;

import ru.makhach.proteus.core.model.dto.base.CityDto;
import ru.makhach.proteus.core.model.dto.base.CountryDto;

import java.util.Arrays;
import java.util.List;

public class Utility {
    public static class City {
        public static CityDto createCityDto(Long id, String name, Long countryId) {
            return new CityDto(id, name, countryId);
        }

        public static List<CityDto> getCityDtos() {
            CityDto city1 = createCityDto(11L, "city1", 666L);
            CityDto city2 = createCityDto(22L, "city2", 666L);
            return Arrays.asList(city1, city2);
        }
    }

    public static class Country {
        public static CountryDto createCountryDto(Long id, String name) {
            return new CountryDto(id, name, "en_En");
        }

        public static List<CountryDto> getCountryDtos() {
            CountryDto country1 = createCountryDto(11L, "country1");
            CountryDto country2 = createCountryDto(22L, "country2");
            return Arrays.asList(country1, country2);
        }
    }
}
