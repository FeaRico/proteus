package ru.makhach.proteus.api.controller;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ru.makhach.proteus.api.utils.Utility;
import ru.makhach.proteus.core.model.dto.base.CityDto;
import ru.makhach.proteus.api.service.CityServiceFacade;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// TODO: 22.06.2022 Дописать тесты на валидацию, можно в отдельном тесте
@SpringBootTest
@AutoConfigureMockMvc
class CityControllerTest {
    private final MockMvc mvc;
    @MockBean
    private CityServiceFacade serviceFacade;
    private final Gson gson;

    private static final String URL = "/api/v1/cities";

    @Autowired
    CityControllerTest(MockMvc mvc) {
        this.mvc = mvc;
        this.gson = new GsonBuilder().create();
    }

    @Test
    void itShouldGetAll() throws Exception {
        List<CityDto> cities = Utility.City.getCityDtos();

        when(serviceFacade.getAllCities())
                .thenReturn(cities);

        MvcResult mvcResult = mvc.perform(get(URL))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        List<CityDto> result = gson.fromJson(content, new TypeToken<List<CityDto>>() {
        }.getType());

        assertThat(result).hasSize(cities.size());
        verify(serviceFacade, only()).getAllCities();
        verifyNoMoreInteractions(serviceFacade);
    }

    @Test
    void itShouldGetAllByCountry() throws Exception {
        List<CityDto> cities = Utility.City.getCityDtos();

        when(serviceFacade.getAllCitiesByCountry(anyLong()))
                .thenReturn(cities);

        MvcResult mvcResult = mvc.perform(get(URL + "/country/{countryId}", "345"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        List<CityDto> result = gson.fromJson(content, new TypeToken<List<CityDto>>() {
        }.getType());

        assertThat(result).hasSize(cities.size());
        verify(serviceFacade, only()).getAllCitiesByCountry(anyLong());
        verifyNoMoreInteractions(serviceFacade);
    }

    @Test
    void itShouldGetById() throws Exception {
        CityDto city = Utility.City.createCityDto(222L, "city", 1L);

        when(serviceFacade.getCityById(anyLong()))
                .thenReturn(city);

        MvcResult mvcResult = mvc.perform(get(URL + "/{id}", "332"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CityDto result = gson.fromJson(content, CityDto.class);

        assertThat(result).isEqualTo(city);
        verify(serviceFacade, only()).getCityById(anyLong());
        verifyNoMoreInteractions(serviceFacade);
    }

    @Test
    void itShouldUpdate() throws Exception {
        CityDto city = Utility.City.createCityDto(23L, "city", 1L);

        when(serviceFacade.updateCity(any(CityDto.class)))
                .thenReturn(city);

        MvcResult mvcResult = mvc.perform(put(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(city)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CityDto result = gson.fromJson(content, CityDto.class);

        assertThat(result).isEqualTo(city);
        verify(serviceFacade, only())
                .updateCity(any(CityDto.class));
        verifyNoMoreInteractions(serviceFacade);
    }

    @Test
    void itShouldSave() throws Exception {
        CityDto city = Utility.City.createCityDto(null, "city", 1L);

        when(serviceFacade.saveCity(any(CityDto.class)))
                .thenReturn(city);

        MvcResult mvcResult = mvc.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(city)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CityDto result = gson.fromJson(content, CityDto.class);

        assertThat(result).isEqualTo(city);
        verify(serviceFacade, only())
                .saveCity(any(CityDto.class));
    }

    @Test
    void itShouldDelete() throws Exception {
        CityDto city = Utility.City.createCityDto(33L, "city", 1L);

        when(serviceFacade.deleteCity(anyLong()))
                .thenReturn(city);

        MvcResult mvcResult = mvc.perform(delete(URL + "/{id}", "32"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CityDto result = gson.fromJson(content, CityDto.class);

        assertThat(result).isEqualTo(city);
        verify(serviceFacade, only())
                .deleteCity(anyLong());
        verifyNoMoreInteractions(serviceFacade);
    }
}