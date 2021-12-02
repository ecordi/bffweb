package com.caphum.bffweb.domain.utils;

import lombok.Data;

@Data
public class Jwt {
    private String token;
    private String bearer = "Bearer";
}