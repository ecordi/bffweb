package com.caphum.bffweb.domain.fichadas;

import com.caphum.bffweb.domain.utils.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

public interface FichadasServices {

    HttpResponse findAll(String IDRH, String DTSTART, String DTEND);

}
