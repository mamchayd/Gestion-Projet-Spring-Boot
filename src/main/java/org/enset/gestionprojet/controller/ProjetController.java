package org.enset.gestionprojet.controller;

import org.enset.gestionprojet.configuration.Config;
import org.enset.gestionprojet.model.Projet;
import org.enset.gestionprojet.model.Responsable;
import org.enset.gestionprojet.pojo.ProjetDTO;
import org.enset.gestionprojet.pojo.ResponsableDTO;
import org.enset.gestionprojet.service.projet.ProjetServiceImpl;
import org.enset.gestionprojet.service.responsable.ResponsableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/projet")
public class ProjetController {

    @Autowired
    ProjetServiceImpl projetService;
    @Autowired
    ResponsableServiceImpl responsableService;

    @Autowired
    Config config;


    @GetMapping("/all")
    public List<ProjetDTO> listProjet(){
        List<Projet> projets=projetService.listProjet();
        return projets.stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    @GetMapping("/allProjetArchive")
    public List<ProjetDTO> listProjetArchive(){
        List<Projet> projets=projetService.listProjetArchive();
        return projets.stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/ajouter")
    public ProjetDTO ajouterProjet(@RequestBody ProjetDTO projetDTO){
        Projet projet=convertToEntity(projetDTO);
        Projet newProject=projetService.addProjet(projet);
        return convertToDTO(newProject);
    }

    @PutMapping("/modifier/{id}")
    public void modifierProjet(@PathVariable(name="id") Long id,@RequestBody ProjetDTO projetDTO){
        Projet projet=convertToEntity(projetDTO);
        projetService.editProjet(id,projet);
    }

    @PostMapping("/affecterRespo/{id}")
    public Projet affecte(@PathVariable(name = "id") Long id,@RequestBody ResponsableDTO responsableDTO){
        Projet projet=projetService.getOne(id);
        Responsable responsable=convertRespToEntity(responsableDTO);
        Responsable neResp=responsableService.getOne(responsable.getId());
        projet.setResponsable(neResp);
        System.out.println("-------------------------------"+projet.getResponsable().getNom());
        return projet;
    }

    @PostMapping("archive/{id}")
    public void archive(@PathVariable(name = "id") Long id){
        projetService.archive(id);
    }


    @GetMapping("all/{id}")
    public Projet detailProjet(@PathVariable(name = "id") Long id){
        return projetService.getOne(id);
    }




    /**
     * @param projet
     * convert entity ti DTO
     * @return
     */
    public ProjetDTO convertToDTO(Projet projet){
        ProjetDTO projetDTO=config.modelMapper().map(projet,ProjetDTO.class);
        projetDTO.setTitre(projet.getTitre());
        projetDTO.setDescription(projet.getDescription());
        projetDTO.setDateDebut(projet.getDateDebut());
        projetDTO.setArchive(projet.isArchive());
        projetDTO.setDuree(projet.getDuree());
        projetDTO.setStatus(projet.getStatus());

        return  projetDTO;
    }

    public Projet convertToEntity(ProjetDTO projetDTO){
        Projet projet=config.modelMapper().map(projetDTO,Projet.class);
        if(projetDTO.getId()!=null){
            System.out.println("id projet dto"+projetDTO.getId());
            projet.setTitre(projetDTO.getTitre());
            projet.setDescription(projetDTO.getDescription());
            projet.setDateDebut(projetDTO.getDateDebut());
            projet.setArchive(projetDTO.isArchive());
            projet.setDuree(projetDTO.getDuree());

        }
        return  projet;
    }

    private Responsable convertRespToEntity(ResponsableDTO responsableDTO){
        Responsable responsable=config.modelMapper().map(responsableDTO,Responsable.class);
        if(responsableDTO.getId()!=null){
            Responsable oldResp=responsableService.getOne(responsableDTO.getId());
        }
        return responsable;
    }




}
