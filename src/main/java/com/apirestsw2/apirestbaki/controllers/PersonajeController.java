package com.apirestsw2.apirestbaki.controllers;

import com.apirestsw2.apirestbaki.models.Personaje;
import com.apirestsw2.apirestbaki.repositories.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personajes")
public class PersonajeController {
    @Autowired
    private PersonajeRepository personajeRepository;
    @GetMapping
    public List<Personaje> getAllPersonajes(){return  personajeRepository.findAll();}
    @GetMapping("/{id}")
    public Personaje getPersonaje(@PathVariable Long id){return personajeRepository.findById(id).orElse(null);}
    @PostMapping("/{id}")
    public Personaje postPersonaje(@RequestBody Personaje personaje){
        return personajeRepository.save(personaje);
    }
    @PutMapping("/{id}")
    public Personaje updatePersonaje(@PathVariable Long id, @RequestBody Personaje personaje) {
        personaje.setId(id);
        return personajeRepository.save(personaje);
    }
    @DeleteMapping("/id")
    public void deletePersonaje(Long id){
        personajeRepository.deleteById(id);
    }
}
