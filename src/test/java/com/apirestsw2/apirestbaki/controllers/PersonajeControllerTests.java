package com.apirestsw2.apirestbaki.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.Optional;
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


@WebMvcTest(PersonajeController.class)
public class PersonajeControllerTests {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @MockBean
    private PersonajeRepository personajeRepository;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetAllPersonajes() throws Exception {
        when(personajeRepository.findAll()).thenReturn(Collections.emptyList());
        mockMvc.perform(get("api/personajes"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
        verify(personajeRepository, times(1)).findAll();
    }

    //Test para el get
    @Test
    public void testGetById() throws Exception {
        Personaje personaje = new Personaje();
        personaje.setId(1L);
        when(personajeRepository.findById(1L)).thenReturn(Optional.of(personaje));
        mockMvc.perform(get("api/personajes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Id").value(1));
        verify(personajeRepository, times(1)).findById(1L);
    }

    //Test para el post
    @Test
    public void postPersonaje() throws Exception {
        Personaje personaje = new Personaje();
        personaje.setId(1L);
        when(personajeRepository.save(any(Personaje.class))).thenReturn(personaje);
        mockMvc.perform(post("/api/personajes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(("{\"id\":null,\"names\":null, \"age\":null,\"gender\":null,\"height\":null,\"origin\":null,\"power\":null,\"classification\":null}")))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.Id").value(1));
        verify(personajeRepository, times(1)).save(any(Personaje.class));
    }

    //Test para el deletePersonaje
    @Test
    public void testDeletePersonaje() throws Exception {
        when(personajeRepository.findById(1L)).thenReturn(Optional.of(new Personaje()));
        doNothing().when(personajeRepository).deleteById(1L);
        mockMvc.perform(delete("api/personajes/1"))
                .andExpect(status().isNoContent());
        verify(personajeRepository, times(1)).findById(1L);
        verify(personajeRepository, times(1)).deleteById(1L);
    }

    //Test para el update
    @Test
    public void testUpdatePersonaje() throws Exception {
        Personaje personaje = new Personaje();
        personaje.setId(1L);
        when(personajeRepository.findById(1L)).thenReturn(Optional.of(personaje));
        when(personajeRepository.save(any(Personaje.class))).thenReturn(personaje);
        mockMvc.perform(put("/api/personajes/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(("{\"id\":1,\"names\":\"nombre\",\"age\":25,\"gender\":\"masculino\",\"height\":180,\"origin\":\"Tierra\",\"power\":\"fuerza\",\"classification\":\"humano\"}")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Id").value(1));
        verify(personajeRepository, times(1)).findById(1L);
        verify(personajeRepository, times(1)).save(any(Personaje.class));
    }
}
