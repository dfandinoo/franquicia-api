package com.seti.franquiciasapi.controller;

import com.seti.franquiciasapi.dto.FranquiciaDto;
import com.seti.franquiciasapi.dto.NameDto;
import com.seti.franquiciasapi.entities.Franquicia;
import com.seti.franquiciasapi.servicies.FranquiciaService;
import com.seti.franquiciasapi.utils.FranquiciaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/franquicia")
public class FranquiciaController {

    @Autowired
    private FranquiciaService franquiciaService;

    @GetMapping
    public ResponseEntity<List<Franquicia>> getFranquicias() {
        return new ResponseEntity<>(franquiciaService.getAllFranquicias(), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<FranquiciaDto> createFranquicia(@RequestBody Franquicia franquicia) {
        FranquiciaDto franquiciaDto = FranquiciaMapper.toDTO(franquiciaService.createFranquicia(franquicia));
        return new ResponseEntity<>(franquiciaDto,HttpStatus.CREATED);
    }

    @PutMapping("/{franquiciaId}/update-name")
    public ResponseEntity<FranquiciaDto> updateNameFranquicia(@PathVariable Long franquiciaId, @RequestBody NameDto nameDto) {
        FranquiciaDto franquicia = FranquiciaMapper.toDTO(franquiciaService.updateNombreFranquicia(franquiciaId, nameDto));
        return new ResponseEntity<>(franquicia, HttpStatus.OK);

    }

}
