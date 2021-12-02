package com.caphum.bffweb.domain.tipodeguardia;

import org.springframework.http.ResponseEntity;

import java.net.http.HttpResponse;

public interface TipoDeGuardiaService {
    HttpResponse findAll(String ID, String NOMBRE);

}
