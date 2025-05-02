package com.seti.franquiciasapi.servicies;

import com.seti.franquiciasapi.dto.FranquiciaDto;
import com.seti.franquiciasapi.dto.NameDto;
import com.seti.franquiciasapi.entities.Franquicia;
import com.seti.franquiciasapi.repository.FranquiciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FranquiciaService {

    @Autowired
    private FranquiciaRepository franquiciaRepository;

    public Franquicia createFranquicia(Franquicia franquicia) {
        return franquiciaRepository.save(franquicia);
    }

    public Franquicia getFranquiciaById(Long id) {
        return franquiciaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Franquicia no encontrada")
        );
    }

    public List<Franquicia> getAllFranquicias() {
        return (List<Franquicia>) franquiciaRepository.findAll();
    }

    public Franquicia updateNombreFranquicia(Long franquiciaId, NameDto nameDto) {
        Franquicia franquicia = franquiciaRepository.findById(franquiciaId)
                .orElseThrow( () -> new RuntimeException("Franquicia no encontrada")
                );
        franquicia.setNombre(nameDto.getNombre());
        return franquiciaRepository.save(franquicia);
    }




}
