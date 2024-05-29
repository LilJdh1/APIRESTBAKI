package com.apirestsw2.apirestbaki.controllers;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
@OpenAPIDefinition(
info = @Info(
        title = "Api Baki",
        version = "1.0",
        description = "Api para visualizar elementos de la serie baki"
),
tags = {
        @Tag(
                name = "Base Controller",
                description = "Controlador para la api, este controlador de extendera a todos los empoints"
            )
        }
)
public class ApiBaseController {
}
