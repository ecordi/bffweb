package com.caphum.bffweb.domain.fichadas;

import java.net.http.HttpResponse;

public interface FichadasServices {
    HttpResponse findAll(String IDRH, String DTSTART, String DTEND);
}
