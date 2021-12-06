package com.caphum.bffweb.domain.fichadas;

import com.caphum.bffweb.domain.utils.Page;

public interface FichadasRepo {
    Page<FichadasModel> findAll();
}
