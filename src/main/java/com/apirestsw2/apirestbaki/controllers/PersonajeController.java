package com.apirestsw2.apirestbaki.controllers;

import com.apirestsw2.apirestbaki.Service.PersonajeService;
import com.apirestsw2.apirestbaki.models.Compe;
import com.apirestsw2.apirestbaki.models.Personaje;
import com.apirestsw2.apirestbaki.repositories.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personajes")
@CrossOrigin(origins = "http://localhost:5173")
public class PersonajeController extends ApiBaseController{
    @Autowired
    private PersonajeService personajeService;
    @GetMapping
    public List<Personaje> getAllPersonajes(){return  personajeService.ListAll();}
    @GetMapping("/{id}")
    public Personaje getPersonaje(@PathVariable Long id){return personajeService.get(id);}
    @PostMapping
    public void createCompe(@RequestBody Personaje personaje) {
        personajeService.save(personaje);
    }
    @PutMapping("/{id}")
    public void updatePersonaje(@PathVariable Long id, @RequestBody Personaje personaje) {
        personaje.setId(id);
        personajeService.save(personaje);}
    @DeleteMapping("/{id}")
    public void deletePersonaje(@PathVariable Long id){
        personajeService.delete(id);
    }
}
