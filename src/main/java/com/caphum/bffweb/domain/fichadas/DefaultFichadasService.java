package com.caphum.bffweb.domain.fichadas;

import net.bytebuddy.dynamic.DynamicType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

import static com.caphum.bffweb.BffwebApplication.URL_API;

@Service
public class DefaultFichadasService implements FichadasServices {
    @Override
    public HttpResponse findAll(String IDRH, String DTSTART, String DTEND) {
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> respuesta = null;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_API + "/FICHADAS/" +
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
        return respuesta;
    }
}