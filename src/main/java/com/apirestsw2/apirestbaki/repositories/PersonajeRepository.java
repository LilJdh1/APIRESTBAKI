package com.apirestsw2.apirestbaki.repositories;

import com.apirestsw2.apirestbaki.models.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonajeRepository extends JpaRepository<Personaje, Long> {
}
