package com.peralta.financenow.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peralta.financenow.service.user.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import templates.user.UserTemplates;

@WebMvcTest(controllers = UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private IUserService iUserService;

    private final static String URL = "/user/";

    @Test
    void registerNewUser() throws Exception {

        String json = objectMapper.writeValueAsString(UserTemplates.getUserDTO());

        mockMvc.perform(MockMvcRequestBuilders.post(URL + "register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void validateLogin() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get(URL + "login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("username", "username")
                        .param("password", "password"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }


}