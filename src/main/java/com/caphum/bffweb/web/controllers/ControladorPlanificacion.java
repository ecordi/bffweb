package com.caphum.bffweb.web.controllers;

import com.caphum.bffweb.domain.planificacion.PlanificacionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("/API")
public class ControladorPlanificacion {
    @Autowired
    PlanificacionService servicePlanificacion;

    @ApiOperation(value = "Listar Planificacion", notes = "Servicio para listar")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Se ha realizado correctamente la consulta"),
            @ApiResponse(code = 404, message = "Datos no encontrados")})
    @GetMapping("/PLFCN/{IDRH}/{DTSTART}/{DTEND}")
    public @ResponseBody CompletableFuture<ResponseEntity> getPlanificacion(
            @PathVariable String IDRH,
            @PathVariable String DTSTART,
            @PathVariable String DTEND
    ) {
        try {
            return CompletableFuture.supplyAsync(() -> ResponseEntity.ok().body(servicePlanificacion.findAll(IDRH, DTSTART, DTEND).join()));
        } catch (Exception e) {
            return CompletableFuture.supplyAsync(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error"));

        }
    }
}
