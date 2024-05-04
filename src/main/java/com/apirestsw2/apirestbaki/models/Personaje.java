package com.apirestsw2.apirestbaki.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "personajes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int age;
    private String gender;
    private int height;
    private String origin;
    private String power;
    private String classification;
}
