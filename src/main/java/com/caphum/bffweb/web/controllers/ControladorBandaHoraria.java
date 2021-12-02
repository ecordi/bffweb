package com.caphum.bffweb.web.controllers;

import com.caphum.bffweb.domain.bandahoraria.BandaHorariaService;
import com.caphum.bffweb.domain.bandahoraria.DefaultBandaHorariaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/API")
public class ControladorBandaHoraria {
    @Autowired
    DefaultBandaHorariaService serviceBandaHoraria;

    @ApiOperation(value = "Listar banda horaria", notes = "Servicio para listar")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Se ha realizado correctamente la consulta"),
            @ApiResponse(code = 404, message = "Datos no encontrados")})
    @GetMapping("/BND_HRIA/{ID}/{NOMBRE}/{HORA_MINUTO}")
    public @ResponseBody
    ResponseEntity<?> getBandaHoraria(@PathVariable String ID,
                                      @PathVariable String NOMBRE,
                                      @PathVariable String HORA_MINUTO) {
        try {
            return ResponseEntity.ok(serviceBandaHoraria.findAll(ID, NOMBRE, HORA_MINUTO).body());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
        }
    }
}
