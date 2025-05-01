package com.seti.franquiciasapi.repository;

import com.seti.franquiciasapi.entities.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
}
