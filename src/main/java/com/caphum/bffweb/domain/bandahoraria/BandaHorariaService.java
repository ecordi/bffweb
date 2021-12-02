package com.caphum.bffweb.domain.bandahoraria;

import org.springframework.http.ResponseEntity;

import java.net.http.HttpResponse;

public interface BandaHorariaService {
    HttpResponse findAll(String ID, String NOMBRE, String HORA_MINUTO);
}
