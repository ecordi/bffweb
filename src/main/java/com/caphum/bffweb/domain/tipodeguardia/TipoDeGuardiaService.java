package com.caphum.bffweb.domain.tipodeguardia;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Map;

public interface TipoDeGuardiaService {
    HttpResponse findAll(String ID, String NOMBRE);
    Map<String, Integer> post(ArrayList<TipoDeGuardiaModel> tipoDeGuardiaModel) throws IOException, InterruptedException;

}