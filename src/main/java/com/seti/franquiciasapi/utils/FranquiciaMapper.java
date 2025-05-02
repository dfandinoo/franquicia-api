package com.seti.franquiciasapi.utils;

import com.seti.franquiciasapi.dto.FranquiciaDto;
import com.seti.franquiciasapi.dto.ProductoDto;
import com.seti.franquiciasapi.dto.SucursalDto;
import com.seti.franquiciasapi.entities.Franquicia;
import com.seti.franquiciasapi.entities.Producto;
import com.seti.franquiciasapi.entities.Sucursal;

import java.util.List;
import java.util.stream.Collectors;

public class FranquiciaMapper {

    public static FranquiciaDto toDTO(Franquicia franquicia) {
        if (franquicia == null) return null;

        FranquiciaDto dto = new FranquiciaDto();
        dto.setId(franquicia.getId());
        dto.setNombre(franquicia.getNombre());

        if (franquicia.getSucursales() != null) {
            List<SucursalDto> sucursales = franquicia.getSucursales().stream()
                    .map(FranquiciaMapper::toDTO)
                    .collect(Collectors.toList());
            dto.setSucursales(sucursales);
        }

        return dto;
    }

    public static SucursalDto toDTO(Sucursal sucursal) {
        if (sucursal == null) return null;

        SucursalDto dto = new SucursalDto();
        dto.setId(sucursal.getId());
        dto.setNombre(sucursal.getNombre());

        if (sucursal.getProductos() != null) {
            List<ProductoDto> productos = sucursal.getProductos().stream()
                    .map(FranquiciaMapper::toDTO)
                    .collect(Collectors.toList());
            dto.setProductos(productos);
        }

        return dto;
    }

    public static ProductoDto toDTO(Producto producto) {
        if (producto == null) return null;

        return new ProductoDto(producto.getId(), producto.getNombre(), producto.getStock());
    }
}
