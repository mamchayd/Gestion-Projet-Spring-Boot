package org.enset.gestionprojet.controller;


import org.enset.gestionprojet.configuration.ObjectMapperUtils;
import org.enset.gestionprojet.model.Projet;
import org.enset.gestionprojet.model.Responsable;
import org.enset.gestionprojet.pojo.ProjetDTO;
import org.enset.gestionprojet.pojo.ResponsableDTO;
import org.enset.gestionprojet.repositories.ResponsableRepository;
import org.enset.gestionprojet.service.responsable.ResponsableServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/responsable")
public class ResponsableController {

    @Autowired
    ResponsableServiceImpl responsableService;




    @GetMapping("/all")
    public List<ResponsableDTO> listProjet(){
        List<Responsable> responsables=responsableService.responsables();
        return ObjectMapperUtils.mapAll(responsables,ResponsableDTO.class);
    }
/*
    @PostMapping("/ajouter")
    public ResponsableDTO ajouterResponsable(@RequestBody ResponsableDTO responsableDTO){
        Responsable responsable=convertToEntity(responsableDTO);
        Responsable newResponsabele=responsableService.addResponsable(responsable);
        return convertToDto(newResponsabele);

    }

    @PutMapping("/modifier/{id}")
    public void modifierResponsable(@PathVariable(name="id") Long id,@RequestBody ResponsableDTO responsableDTO){
        Responsable responsable=convertToEntity(responsableDTO);
        responsableService.editResponsable(id,responsable);
    }

    @DeleteMapping("/supprimer/{id}")
    public void suppprimerResponsable(@PathVariable(name = "id") Long id){
        responsableService.deleteResponsable(id);
    }

 */



}
