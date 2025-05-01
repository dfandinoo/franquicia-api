package com.seti.franquiciasapi.controller;

import com.seti.franquiciasapi.entities.Producto;
import com.seti.franquiciasapi.entities.Sucursal;
import com.seti.franquiciasapi.servicies.ProductoService;
import com.seti.franquiciasapi.servicies.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos/")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private SucursalService sucursalService;

    @GetMapping("/franquicia/{franquiciaId}/max-stock")
    public List<Producto> productosConMayorStockPorSucursal(@PathVariable Long franquiciaId) {
        return productoService.getProductosWithMaxStockBySucursalOfFranquicia(franquiciaId);
    }

    @PostMapping("/sucursal/{sucursalId}")
    public Producto createProducto(@PathVariable Long sucursalId,@RequestBody Producto producto) {
        return productoService.createProducto(sucursalId, producto);
    }
}
