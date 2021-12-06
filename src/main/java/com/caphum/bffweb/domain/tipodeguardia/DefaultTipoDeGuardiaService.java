package com.caphum.bffweb.domain.tipodeguardia;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.caphum.bffweb.BffwebApplication.URL_API;

@Service
public class DefaultTipoDeGuardiaService implements TipoDeGuardiaService {
    @Override
    public HttpResponse findAll(String ID, String NOMBRE) {
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> respuesta = null;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_API + "/TP_GDA/" +
                        ID + "/" +
                        NOMBRE + "/"))
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

    @Override
    public Map<String, Integer> post(ArrayList<TipoDeGuardiaModel> tipoDeGuardiaModel) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> respuesta = null;
        Map<String, Integer >resultado = new HashMap<>();
        for (TipoDeGuardiaModel tipo:tipoDeGuardiaModel) {
            String inputJson = "{ \"fecha\":\"" + tipo.getIDRH() + "\", \"id\":\"" +
                    tipo.getID()+"\", \"idrh\":\"" +
                    tipo.getFECHA()+"\" }";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL_API+"/TIPO_DE_GUARDIA"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(inputJson))
                    .build();

            respuesta=client.send(request, HttpResponse.BodyHandlers.ofString());
            resultado.put(tipo.getID(), respuesta.statusCode());
        }

        return resultado;
    }
}