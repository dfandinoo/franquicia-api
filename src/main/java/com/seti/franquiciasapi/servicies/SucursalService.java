package com.seti.franquiciasapi.servicies;

import com.seti.franquiciasapi.entities.Franquicia;
import com.seti.franquiciasapi.entities.Sucursal;
import com.seti.franquiciasapi.repository.FranquiciaRepository;
import com.seti.franquiciasapi.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SucursalService {

    @Autowired
    private FranquiciaRepository franquiciaRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    public Sucursal createSucursal(Long franquiciaId, Sucursal sucursal) {
        Franquicia franquicia = franquiciaRepository.findById(franquiciaId)
                .orElseThrow(
                        () -> new RuntimeException("Franquicia no encontrada")
                );
        sucursal.setFranquicia(franquicia);
        return sucursalRepository.save(sucursal);
    }

}
