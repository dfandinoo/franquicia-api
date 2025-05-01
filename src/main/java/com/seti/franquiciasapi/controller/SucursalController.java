package com.seti.franquiciasapi.controller;

import com.seti.franquiciasapi.entities.Franquicia;
import com.seti.franquiciasapi.entities.Sucursal;
import com.seti.franquiciasapi.repository.SucursalRepository;
import com.seti.franquiciasapi.servicies.FranquiciaService;
import com.seti.franquiciasapi.servicies.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Sucursal createSucursal(@PathVariable Long idFranquicia, @RequestBody Sucursal sucursal) {
        return sucursalService.createSucursal(idFranquicia, sucursal);
    }

}
