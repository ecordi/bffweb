package com.caphum.bffweb.domain.guardia;

import java.net.http.HttpResponse;

public interface GuardiaService {
    HttpResponse findAll(String IDRH, String DTSTART, String DTEND);
}