package org.enset.gestionprojet.controller;

import org.enset.gestionprojet.model.Responsable;
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

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/all")
    public List<ResponsableDTO> getAll(){
        List<Responsable> responsables=responsableService.responsables();
        return responsables.stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

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


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    /**
     * Convert entity to DTO
     * @param responsable
     * @return
     */
    private ResponsableDTO convertToDto(Responsable responsable) {
        ResponsableDTO responsableDTO = modelMapper.map(responsable, ResponsableDTO.class);
        responsableDTO.setEmail(responsable.getEmail());
        responsableDTO.setPrenom(responsable.getPrenom());
        responsableDTO.setNom(responsable.getNom());
        responsableDTO.setTel(responsable.getTel());
        return responsableDTO;
    }

    /**
     * Convert DTO to entity
     * @param responsableDTO
     * @return
     */
    private Responsable convertToEntity(ResponsableDTO responsableDTO){
        Responsable responsable=modelMapper.map(responsableDTO,Responsable.class);
        if(responsableDTO.getId()!=null){
            Responsable oldResp=responsableService.getOne(responsableDTO.getId());
            responsable.setEmail(oldResp.getEmail());
            responsable.setPrenom(oldResp.getPrenom());
            responsable.setNom(oldResp.getNom());
            responsable.setTasks(oldResp.getTasks());
            responsable.setTel(oldResp.getTel());
            responsable.setProjets(oldResp.getProjets());
        }
        return responsable;
    }


}
