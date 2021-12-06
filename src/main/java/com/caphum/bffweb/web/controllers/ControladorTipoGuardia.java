package com.caphum.bffweb.web.controllers;

import com.caphum.bffweb.domain.tipodeguardia.TipoDeGuardiaModel;
import com.caphum.bffweb.domain.tipodeguardia.TipoDeGuardiaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Map;

import static com.caphum.bffweb.BffwebApplication.URL_API;

@RestController
@RequestMapping("/API")
public class ControladorTipoGuardia {
    @Autowired
    TipoDeGuardiaService serviceTipoDeGuardia;

    @ApiOperation(value = "Listar tipos de guardia", notes = "Servicio para listar")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Se ha realizado correctamente la consulta"),
            @ApiResponse(code = 404, message = "Datos no encontrados")})
    @GetMapping("/TP_GDA/{ID}/{NOMBRE}")
    public ResponseEntity getTipoDeGuardias(
            @PathVariable String ID,
            @PathVariable String NOMBRE) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(serviceTipoDeGuardia.findAll(ID, NOMBRE));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
        }
    }

    @ApiOperation(value = "Listar tipos de guardia", notes = "Servicio para listar")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Se ha realizado correctamente la consulta"),
            @ApiResponse(code = 404, message = "Datos no encontrados")})
    @PostMapping("/TP_GDA")
    public ResponseEntity<Map> postBody(@RequestBody ArrayList<TipoDeGuardiaModel> tpGuardia) throws IOException, InterruptedException {

        return ResponseEntity.status(HttpStatus.OK).body(serviceTipoDeGuardia.post(tpGuardia));
    }
}
