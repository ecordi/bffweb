package com.caphum.bffweb.web.controllers;

import com.caphum.bffweb.domain.fichadas.DefaultFichadasService;
import com.caphum.bffweb.domain.fichadas.FichadasModel;
import com.caphum.bffweb.domain.fichadas.FichadasServices;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/API")
public class ControladorFichadas {
    @Autowired
    private FichadasServices service;

    @ApiOperation(value = "Listar Fichadas", notes = "Servicio para listar")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Se ha realizado correctamente la consulta"),
            @ApiResponse(code = 404, message = "Datos no encontrados")})
    @GetMapping("/FICHADAS/{IDRH}/{DTSTART}/{DTEND}")
    public ResponseEntity getFichadas(@PathVariable String IDRH,
                                                     @PathVariable String DTSTART,
                                                     @PathVariable String DTEND
    ) {
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.findAll(IDRH, DTSTART, DTEND).body());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
        }
    }
}