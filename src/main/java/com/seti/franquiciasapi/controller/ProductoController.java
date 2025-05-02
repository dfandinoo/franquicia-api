package com.seti.franquiciasapi.controller;

import com.seti.franquiciasapi.dto.NameDto;
import com.seti.franquiciasapi.dto.ProductoDto;
import com.seti.franquiciasapi.dto.ProductoMaxStockDto;
import com.seti.franquiciasapi.dto.ProductoStockUpdateDto;
import com.seti.franquiciasapi.entities.Franquicia;
import com.seti.franquiciasapi.entities.Producto;
import com.seti.franquiciasapi.servicies.ProductoService;
import com.seti.franquiciasapi.servicies.SucursalService;
import com.seti.franquiciasapi.utils.FranquiciaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private SucursalService sucursalService;

    @GetMapping
    public ResponseEntity<List<Producto>> getProductos() {
        return new ResponseEntity<>(productoService.getAllProductos(), HttpStatus.OK);
    }

    @GetMapping("/franquicia/{franquiciaId}/max-stock")
    public ResponseEntity<List<ProductoMaxStockDto>> productosConMayorStockPorSucursal(@PathVariable Long franquiciaId) {
        List<ProductoMaxStockDto> productoMaxStock = productoService.getProductosWithMaxStockBySucursalOfFranquicia(franquiciaId);
        return new ResponseEntity<>(productoMaxStock, HttpStatus.OK);
    }

    @PostMapping("/sucursal/{sucursalId}")
    public ResponseEntity<ProductoDto> createProducto(@PathVariable Long sucursalId, @RequestBody Producto producto) {
        ProductoDto productoDto = FranquiciaMapper.toDTO(productoService.createProducto(sucursalId, producto));
        return new ResponseEntity<>(productoDto, HttpStatus.CREATED);
    }

    @PutMapping("/{productoId}/update-stock")
    public ResponseEntity<ProductoDto> updateStock(@PathVariable Long productoId, @RequestBody ProductoStockUpdateDto productoStockUpdateDto) {
        Producto productoUpdateStock = productoService.updateStock(productoId, productoStockUpdateDto.getNuevoStock());
        ProductoDto productoDto = FranquiciaMapper.toDTO(productoUpdateStock);
        return new ResponseEntity<>(productoDto, HttpStatus.OK);
    }

    @PutMapping("/{productoId}/update-name")
    public ResponseEntity<ProductoDto> updateNameFranquicia(@PathVariable Long productoId, @RequestBody NameDto nameDto) {
        ProductoDto producto = FranquiciaMapper.toDTO(productoService.updateNombreProducto(productoId, nameDto));
        return new ResponseEntity<>(producto, HttpStatus.OK);

    }
}
