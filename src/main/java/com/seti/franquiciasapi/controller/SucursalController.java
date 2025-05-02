package com.seti.franquiciasapi.controller;

import com.seti.franquiciasapi.dto.SucursalDto;
import com.seti.franquiciasapi.entities.Franquicia;
import com.seti.franquiciasapi.entities.Sucursal;
import com.seti.franquiciasapi.repository.SucursalRepository;
import com.seti.franquiciasapi.servicies.FranquiciaService;
import com.seti.franquiciasapi.servicies.SucursalService;
import com.seti.franquiciasapi.utils.FranquiciaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/franquicias/")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @Autowired
    private FranquiciaService franquiciaService;

    @PostMapping("/{idFranquicia}/sucursales")
    public ResponseEntity<SucursalDto> createSucursal(@PathVariable Long idFranquicia, @RequestBody Sucursal sucursal) {
        SucursalDto sucursalDto = FranquiciaMapper.toDTO(sucursalService.createSucursal(idFranquicia, sucursal));
        return new ResponseEntity<>(sucursalDto, HttpStatus.CREATED);
    }

}
