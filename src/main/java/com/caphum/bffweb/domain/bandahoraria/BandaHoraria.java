package com.caphum.bffweb.domain.bandahoraria;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BandaHoraria {
    @ApiModelProperty(required = true)
    @NotBlank(message = "Name field is required")
    String bandaHoraria;
    @ApiModelProperty(required = true)
    @NotBlank(message = "Name field is required")
    String descripcion;
    @ApiModelProperty(required = true)
    @NotBlank(message = "Name field is required")
    String horaEntrada;
    @ApiModelProperty(required = true)
    @NotBlank(message = "Name field is required")
    String minutoEntrada;
    @ApiModelProperty(required = true)
    @NotBlank(message = "Name field is required")
    String horaSalida;
    @ApiModelProperty(required = true)
    @NotBlank(message = "Name field is required")
    String minutoSalida;

}