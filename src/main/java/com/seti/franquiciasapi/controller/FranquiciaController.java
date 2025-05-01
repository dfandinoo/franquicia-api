package com.seti.franquiciasapi.controller;

import com.seti.franquiciasapi.entities.Franquicia;
import com.seti.franquiciasapi.repository.FranquiciaRepository;
import com.seti.franquiciasapi.servicies.FranquiciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FranquiciaController {

    @Autowired
    private FranquiciaService franquiciaService;

    @GetMapping
    public ResponseEntity<List<Franquicia>> getFranquicias() {
        List<Franquicia> franquicias = new ArrayList<>();
        franquicias.addAll(franquiciaService.getAllFranquicias());
        return new ResponseEntity<>(franquicias, HttpStatus.CREATED);

    }

    @PostMapping
    public Franquicia createFranquicia(@RequestBody Franquicia franquicia) {
        return franquiciaService.createFranquicia(franquicia);
    }

}
