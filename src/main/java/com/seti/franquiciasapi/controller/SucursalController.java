package com.seti.franquiciasapi.controller;

import com.seti.franquiciasapi.dto.NameDto;
import com.seti.franquiciasapi.dto.SucursalDto;
import com.seti.franquiciasapi.entities.Sucursal;
import com.seti.franquiciasapi.servicies.SucursalService;
import com.seti.franquiciasapi.utils.FranquiciaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sucursal")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping
    public ResponseEntity<List<Sucursal>> getSucursales() {
        return new ResponseEntity<>(sucursalService.getAllSucursales(), HttpStatus.OK);

    }

    @PostMapping("/franquicia/{idFranquicia}")
    public ResponseEntity<SucursalDto> createSucursal(@PathVariable Long idFranquicia, @RequestBody Sucursal sucursal) {
        SucursalDto sucursalDto = FranquiciaMapper.toDTO(sucursalService.createSucursal(idFranquicia, sucursal));
        return new ResponseEntity<>(sucursalDto, HttpStatus.CREATED);
    }

    @PutMapping("/{sucursalId}/update-name")
    public ResponseEntity<SucursalDto> updateNameSucursal(@PathVariable Long sucursalId, @RequestBody NameDto nameDto) {
        SucursalDto sucursal = FranquiciaMapper.toDTO(sucursalService.updateNombreSucursal(sucursalId, nameDto));
        return new ResponseEntity<>(sucursal, HttpStatus.OK);

    }



}
