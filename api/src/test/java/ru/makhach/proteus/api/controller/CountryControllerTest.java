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
import ru.makhach.proteus.core.model.dto.base.CountryDto;
import ru.makhach.proteus.api.service.CountryServiceFacade;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CountryControllerTest {
    private final MockMvc mvc;
    @MockBean
    private CountryServiceFacade serviceFacade;
    private final Gson gson;

    private final String URL = "/api/v1/countries";

    @Autowired
    CountryControllerTest(MockMvc mvc) {
        this.mvc = mvc;
        this.gson = new GsonBuilder().create();
    }

    @Test
    void itShouldGetAll() throws Exception {
        List<CountryDto> countries = Utility.Country.getCountryDtos();

        when(serviceFacade.getAllCountries())
                .thenReturn(countries);

        MvcResult mvcResult = mvc.perform(get(URL))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        List<CountryDto> result = gson.fromJson(content, new TypeToken<List<CountryDto>>() {
        }.getType());

        assertThat(result).hasSize(countries.size());
        verify(serviceFacade, only())
                .getAllCountries();
        verifyNoMoreInteractions(serviceFacade);
    }

    @Test
    void itShouldGetById() throws Exception {
        CountryDto country = Utility.Country.createCountryDto(2L, "country");

        when(serviceFacade.getCountryById(anyLong()))
                .thenReturn(country);

        MvcResult mvcResult = mvc.perform(get(URL + "/{id}", "999"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CountryDto result = gson.fromJson(content, CountryDto.class);

        assertThat(result).isEqualTo(country);
        verify(serviceFacade, only())
                .getCountryById(anyLong());
        verifyNoMoreInteractions(serviceFacade);
    }

    @Test
    void itShouldGetByCode() throws Exception {
        CountryDto country = Utility.Country.createCountryDto(3L, "country");

        when(serviceFacade.getCountryByCode(anyString()))
                .thenReturn(country);

        MvcResult mvcResult = mvc.perform(get(URL + "/code/{code}", "en_En"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CountryDto result = gson.fromJson(content, CountryDto.class);

        assertThat(result).isEqualTo(country);
        verify(serviceFacade, only())
                .getCountryByCode(anyString());
        verifyNoMoreInteractions(serviceFacade);
    }

    @Test
    void itShouldUpdate() throws Exception {
        CountryDto country = Utility.Country.createCountryDto(4L, "country");

        when(serviceFacade.updateCountry(any(CountryDto.class)))
                .thenReturn(country);

        MvcResult mvcResult = mvc.perform(put(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(country)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CountryDto result = gson.fromJson(content, CountryDto.class);

        assertThat(result).isEqualTo(country);
        verify(serviceFacade, only())
                .updateCountry(any(CountryDto.class));
        verifyNoMoreInteractions(serviceFacade);
    }

    @Test
    void itShouldSave() throws Exception {
        CountryDto country = Utility.Country.createCountryDto(null, "country");

        when(serviceFacade.saveCountry(any(CountryDto.class)))
                .thenReturn(country);

        MvcResult mvcResult = mvc.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(country)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CountryDto result = gson.fromJson(content, CountryDto.class);

        assertThat(result).isEqualTo(country);
        verify(serviceFacade, only())
                .saveCountry(any(CountryDto.class));
    }

    @Test
    void itShouldDelete() throws Exception {
        CountryDto country = Utility.Country.createCountryDto(5L, "country");

        when(serviceFacade.deleteCountry(anyLong()))
                .thenReturn(country);

        MvcResult mvcResult = mvc.perform(delete(URL + "/{id}", "22"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CountryDto result = gson.fromJson(content, CountryDto.class);

        assertThat(result).isEqualTo(country);
        verify(serviceFacade, only())
                .deleteCountry(anyLong());
        verifyNoMoreInteractions(serviceFacade);
    }
}