package com.caphum.bffweb.comun;

import com.caphum.bffweb.domain.utils.Page;
import com.caphum.bffweb.web.dto.PageDto;
import lombok.Data;

import static com.caphum.bffweb.BffwebApplication.URL_API;

@Data
public class PageUtils {
    public static final int DEFAULT_PAGE_SIZE = 30;


    public static PageDto toPageDto(Page<?> page, String urlPath) {
        PageDto dto = new PageDto();
        dto.setContent(page.getContent());
        dto.setNextPage(page.isHasNextPage() ? URL_API + urlPath + "?page=" + (page.getCurrentPage() + 1) : null);
        dto.setPreviousPage(page.isHasPreviousPage() ? URL_API + urlPath + "?page=" + (page.getCurrentPage() - 1) : null);
        return dto;
    }
}
