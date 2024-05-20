package com.apirestsw2.apirestbaki.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class corsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173/")//Escribir la URL del proyecto front a conectar
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")//Metodos a permitir desde el front, GET, POST, PUT, DELETE
                .allowCredentials(true);
    }
}
