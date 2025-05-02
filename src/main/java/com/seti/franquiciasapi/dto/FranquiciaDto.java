package com.seti.franquiciasapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FranquiciaDto {

    private Long id;
    private String nombre;
    private List<SucursalDto> sucursales;
}
