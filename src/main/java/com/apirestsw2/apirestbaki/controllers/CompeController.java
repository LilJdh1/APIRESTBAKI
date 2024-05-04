package com.apirestsw2.apirestbaki.controllers;

import com.apirestsw2.apirestbaki.Service.CompeService;
import com.apirestsw2.apirestbaki.models.Compe;
import com.apirestsw2.apirestbaki.repositories.CompeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competencias")
public class CompeController {
    @Autowired
    private CompeRepository compeRepository;

    @GetMapping
    public List<Compe> getAllCompetencias(){
        return compeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Compe getCompeByID(@PathVariable Long id){
        return compeRepository.findById(id).orElse(null);
    }
}
