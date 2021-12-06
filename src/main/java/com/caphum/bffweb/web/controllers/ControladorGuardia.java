package com.caphum.bffweb.web.controllers;

import com.caphum.bffweb.domain.guardia.GuardiaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/API")
public class ControladorGuardia {
    @Autowired
    GuardiaService serviceGuardia;

    @ApiOperation(value = "Listar Guardias", notes = "Servicio para listar")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Se ha realizado correctamente la consulta"),
            @ApiResponse(code = 404, message = "Datos no encontrados")})
    @GetMapping("/GDA/{ID}/{NOMBRE}/{HORA_MINUTO}")
    public @ResponseBody
    ResponseEntity<?> getGuardias(@PathVariable String ID,
                                  @PathVariable String NOMBRE,
                                  @PathVariable String HORA_MINUTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(serviceGuardia.findAll(ID,NOMBRE,HORA_MINUTO).body());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
        }
    }
}
