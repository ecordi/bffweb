package com.caphum.bffweb.domain.planificacion;

import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public interface PlanificacionService {
    CompletableFuture<String> findAll(String IDRH, String DTSTART, String DTEND);
}
