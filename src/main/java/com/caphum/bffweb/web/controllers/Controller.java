package com.caphum.bffweb.web.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.coyote.Response;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.caphum.bffweb.BffwebApplication.URL_API;

@RestController
@RequestMapping("/API")
public class Controller {

 

  


   /* @ApiOperation(value = "Post para tipos de guardia", notes = "Servicio para listar")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Se ha realizado correctamente la consulta"),
            @ApiResponse(code = 404, message = "Datos no encontrados")})
    @PostMapping("/bandahoraria")
    public @ResponseBody
    ResponseEntity<?> postTipoDeGuardias() throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

            //HTTP GET method
            HttpGet httpget = new HttpGet(URL_API+"/TIPO_DE_GUARDIA");
            System.out.println("Executing request " + httpget.getRequestLine());

            // Create a custom response handler
            ResponseHandler< String > responseHandler = response - > {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
            };
            String responseBody = httpclient.execute(httpget, responseHandler);

            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        }
        return ResponseEntity.status(HttpStatus.OK).body(respuesta.body());

    }*/
}

