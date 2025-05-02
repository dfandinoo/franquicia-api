package com.seti.franquiciasapi.repository;

import com.seti.franquiciasapi.dto.ProductoMaxStockDto;
import com.seti.franquiciasapi.entities.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

    @Query("SELECT p.nombre AS productoNombre, s.nombre AS sucursalNombre, p.stock AS stock FROM Producto p JOIN p.sucursal s JOIN s.franquicia f WHERE f.id = :franquiciaId AND p.stock = ( SELECT MAX(p2.stock) FROM Producto p2 WHERE p2.sucursal = s)")
    List<ProductoMaxStockDto> findProductosConMasStockPorSucursalDeFranquicia(@Param("franquiciaId") Long franquiciaId);
}
