package com.apirestsw2.apirestbaki.Service;

import com.apirestsw2.apirestbaki.models.Compe;
import com.apirestsw2.apirestbaki.repositories.CompeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompeService {
    @Autowired
    private CompeRepository compeRepository;

    //Listar items
    public List<Compe> ListAll(){
        return compeRepository.findAll();
    }

    //Guardar
    public void save(Compe compe){
        compeRepository.save(compe);
    }

    //Obtener ID
    public Compe get(Long id) {
        return compeRepository.findById(id).get();
    }

    //Eliminar
    public void delete(Long id){
        compeRepository.deleteById(id);
    }
}
