package com.peralta.financenow.controller;

import com.peralta.financenow.service.filter.FilterFacade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = FilterController.class)
class FilterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FilterFacade<?> filterFacade;

    private static final String URL = "/filter";

    @Test
    @DisplayName("Should return filter response")
    void getFiltersResponse() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("filterKeys", "0"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

}