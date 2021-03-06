package com.caphum.bffweb.domain.planificacion;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import static com.caphum.bffweb.BffwebApplication.URL_API;

@Service
public class DefaultPlanificacionService implements PlanificacionService {
    @Async
    @Override
    public CompletableFuture<String> findAll(String IDRH, String DTSTART, String DTEND) {

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> respuesta = null;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_API+"/PLFCN/" +
                        IDRH + "/" +
                        DTSTART + "/" +
                        DTEND))
                .GET()
                .build();
        try {
            respuesta = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(respuesta.body());
    }
}