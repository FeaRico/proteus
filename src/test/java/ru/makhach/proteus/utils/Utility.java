package ru.makhach.proteus.utils;

import ru.makhach.proteus.model.dto.base.CityDto;

import java.util.Arrays;
import java.util.List;

public class Utility {
    public static class City {
        public static CityDto createCityDto(Long id, String name, Long countryId) {
            return new CityDto(id, name, countryId);
        }

        public static List<CityDto> getCityDtos() {
            CityDto city1 = Utility.City.createCityDto(12L, "City1", 434L);
            CityDto city2 = Utility.City.createCityDto(54L, "City2", 666L);
            return Arrays.asList(city1, city2);
        }
    }


}
