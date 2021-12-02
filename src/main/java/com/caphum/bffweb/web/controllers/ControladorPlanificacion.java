package com.caphum.bffweb.web.controllers;

import com.caphum.bffweb.domain.planificacion.PlanificacionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.caphum.bffweb.BffwebApplication.URL_API;

@RestController
@RequestMapping("/API")
public class ControladorPlanificacion {
    @Autowired
    PlanificacionService servicePlanificacion;
    @Async
    @ApiOperation(value = "Listar Planificacion", notes = "Servicio para listar")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Se ha realizado correctamente la consulta"),
            @ApiResponse(code = 404, message = "Datos no encontrados")})
    @GetMapping("/PLFCN/{IDRH}/{DTSTART}/{DTEND}")
    public ResponseEntity getPlanificacion(
            @PathVariable String IDRH,
            @PathVariable String DTSTART,
            @PathVariable String DTEND
    ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicePlanificacion.findAll(IDRH,DTSTART,DTEND));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
        }
    }

}
