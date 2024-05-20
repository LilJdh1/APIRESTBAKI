package com.apirestsw2.apirestbaki.controllers;

import com.apirestsw2.apirestbaki.Service.CompeService;
import com.apirestsw2.apirestbaki.models.Compe;
import com.apirestsw2.apirestbaki.repositories.CompeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competencias")
public class CompeController extends ApiBaseController{
    @Autowired
    private CompeService compeService;

    @GetMapping
    public List<Compe> getAllCompe(){
        return compeService.ListAll();
    }

    @PutMapping("/{id}")
    public void updateCompe(@PathVariable Long id, @RequestBody Compe compe) {
        compe.setId(id);
        compeService.save(compe);
    }
    @PostMapping
    public void createCompe(@RequestBody Compe compe) {
        compeService.save(compe);
    }
    @DeleteMapping("/{id}")
    public void deleteCompe(@PathVariable Long id) {
        compeService.delete(id);
    }
}
