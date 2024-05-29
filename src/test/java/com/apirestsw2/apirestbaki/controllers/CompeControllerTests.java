package com.apirestsw2.apirestbaki.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.Optional;

import com.apirestsw2.apirestbaki.Service.CompeService;
import com.apirestsw2.apirestbaki.models.Compe;
import com.apirestsw2.apirestbaki.models.Personaje;
import com.apirestsw2.apirestbaki.repositories.PersonajeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@WebMvcTest(CompeController.class)
public class CompeControllerTests {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @MockBean
    private CompeService compeService;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetAllCompe() throws Exception {
        when(compeService.ListAll()).thenReturn(Collections.emptyList());
        mockMvc.perform(get("api/compe"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
        verify(compeService, times(1)).ListAll();
    }

    @Test
    public void testUpdateCompe() throws Exception {
        Compe compe = new Compe();
        compe.setId(1L);
        doReturn(compe).when(compeService).save(any(Compe.class));
        mockMvc.perform(put("/api/compe/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(("{\"id\":1,\"...\":\"...\"}")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
        verify(compeService, times(1)).save(any(Compe.class));
    }

    @Test
    public void testCreateCompe() throws Exception {
        Compe compe = new Compe();
        doReturn(compe).when(compeService).save(any(Compe.class));
        mockMvc.perform(post("/api/compe")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(("{\"id\":null,\"...\":\"...\"}")))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists());
        verify(compeService, times(1)).save(any(Compe.class));
    }

    @Test
    public void testDeleteCompe() throws Exception {
        doNothing().when(compeService).delete(1L);
        mockMvc.perform(delete("api/compe/1"))
                .andExpect(status().isNoContent());
        verify(compeService, times(1)).delete(1L);
    }
}
