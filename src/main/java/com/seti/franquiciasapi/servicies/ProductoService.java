package com.seti.franquiciasapi.servicies;

import com.seti.franquiciasapi.entities.Producto;
import com.seti.franquiciasapi.entities.Sucursal;
import com.seti.franquiciasapi.repository.ProductoRepository;
import com.seti.franquiciasapi.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    public Producto createProducto(Long sucursalId, Producto producto) {
        Sucursal sucursal = sucursalRepository.findById(sucursalId).orElseThrow(
                () -> new RuntimeException("Sucursal no encontrada")
        );
        producto.setSucursal(sucursal);
        return productoRepository.save(producto);
    }

    public void deleteProducto(Long productoId) {
        productoRepository.deleteById(productoId);
    }

    public Producto updateStock(Long productoId, int nuevoStock) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setStock(nuevoStock);
        return productoRepository.save(producto);
    }

    public List<Producto> getProductosWithMaxStockBySucursalOfFranquicia(Long franquiciaId) {
        return null;
    }

}
