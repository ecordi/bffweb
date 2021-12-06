package com.caphum.bffweb.domain.fichadas;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FichadasModel {
    @ApiModelProperty(required = true)
    @NotBlank(message = "Name field is required")
    String IDRH;
    @ApiModelProperty(required = true)
    @NotBlank(message = "Name field is required")
    String DTSTART;
    @ApiModelProperty(required = true)
    @NotBlank(message = "Name field is required")
    String DTEND;
}