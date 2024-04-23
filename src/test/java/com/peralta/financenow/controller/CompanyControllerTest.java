package com.peralta.financenow.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peralta.financenow.service.company.ICompanyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import templates.company.CompanyTemplates;

@WebMvcTest(controllers = CompanyController.class)
class CompanyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ICompanyService iCompanyService;

    private static final String URL = "/company/";

    @Test
    @DisplayName("Should create a company")
    void createCompany() throws Exception {

        String json = objectMapper.writeValueAsString(CompanyTemplates.getCompanyCreateRequest());

        mockMvc.perform(MockMvcRequestBuilders.post(URL + "create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

}