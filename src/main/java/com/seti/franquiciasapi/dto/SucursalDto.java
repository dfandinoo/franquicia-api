package com.seti.franquiciasapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SucursalDto {

    private Long id;
    private String nombre;
    private List<ProductoDto> productos;
}
