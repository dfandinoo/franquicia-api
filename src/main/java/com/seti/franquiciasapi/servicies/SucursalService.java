package com.seti.franquiciasapi.servicies;

import com.seti.franquiciasapi.dto.NameDto;
import com.seti.franquiciasapi.entities.Franquicia;
import com.seti.franquiciasapi.entities.Sucursal;
import com.seti.franquiciasapi.repository.FranquiciaRepository;
import com.seti.franquiciasapi.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Sucursal getSucursalById(Long sucursalId) {
        return sucursalRepository.findById(sucursalId).orElseThrow(
                () -> new RuntimeException("Sucursal no encontrada")
        );
    }

    public Sucursal updateNombreSucursal(Long sucursalId, NameDto nameDto) {
        Sucursal sucursal = sucursalRepository.findById(sucursalId)
                .orElseThrow( () -> new RuntimeException("Sucursal no encontrada")
                );
        sucursal.setNombre(nameDto.getNombre());
        return sucursalRepository.save(sucursal);
    }

    public List<Sucursal> getAllSucursales() {
        return (List<Sucursal>) sucursalRepository.findAll();
    }

}
