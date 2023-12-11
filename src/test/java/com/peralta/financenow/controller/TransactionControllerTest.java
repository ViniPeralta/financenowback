package com.peralta.financenow.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peralta.financenow.service.transaction.ITransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import templates.transaction.TransactionTemplates;

@WebMvcTest(controllers = TransactionController.class)
class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ITransactionService iTransactionService;

    private static final String URL = "/transaction/";

    @Test
    void getTransactionsExtract() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get(URL + "extract")
                .contentType(MediaType.APPLICATION_JSON)
                .param("month", "1")
                .param("year", "2023")
                .param("user", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void getTransactionsByDate() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get(URL + "list")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("dateFrom", "10/02/2023")
                        .param("dateTo", "10/02/2023")
                        .param("userId", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void deleteByIdList() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete(URL + "delete")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("idList", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void registerNewTransaction() throws Exception {

        String json = objectMapper.writeValueAsString(TransactionTemplates.getTransactionRequest());

        mockMvc.perform(MockMvcRequestBuilders.post(URL + "register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void updateTransaction() throws Exception {

        String json = objectMapper.writeValueAsString(TransactionTemplates.getTransactionDTO());

        mockMvc.perform(MockMvcRequestBuilders.post(URL + "update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("dateFrom", "10/02/2023")
                        .param("dateTo", "10/02/2023")
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

}