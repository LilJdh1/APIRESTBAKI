package com.apirestsw2.apirestbaki.Service;

import com.apirestsw2.apirestbaki.models.Personaje;
import com.apirestsw2.apirestbaki.repositories.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeService {
    @Autowired
    private PersonajeRepository personajeRepository;
    //Listar personajes
    public List<Personaje> ListAll(){
        return personajeRepository.findAll();
    }
    
    //Guardar
    public void save(Personaje personaje){
        personajeRepository.save(personaje);
    }

    //Obtener id personaje
    public Personaje get(Long id){
        return personajeRepository.findById(id).get();
    }

    //Eliminar personaje
    public void delete(Long id){
        personajeRepository.deleteById(id);
    }
}
