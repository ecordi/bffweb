package com.caphum.bffweb.domain.guardia;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.caphum.bffweb.BffwebApplication.URL_API;

@Service
public class DefaultGuardiaService implements GuardiaService {
    @Override
    public HttpResponse findAll(String ID, String NOMBRE, String HORA_MINUTO) {
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> respuesta = null;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_API + "/GDA/" +
                        ID + "/" +
                        NOMBRE + "/" +
                        HORA_MINUTO))
                .GET()
                .build();
        try {
            respuesta = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return respuesta;
    }
}