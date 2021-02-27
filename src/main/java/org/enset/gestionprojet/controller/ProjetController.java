package org.enset.gestionprojet.controller;

import org.enset.gestionprojet.configuration.ObjectMapperUtils;
import org.enset.gestionprojet.model.Projet;
import org.enset.gestionprojet.model.Responsable;
import org.enset.gestionprojet.model.Task;
import org.enset.gestionprojet.pojo.ProjetDTO;
import org.enset.gestionprojet.pojo.ResponsableDTO;
import org.enset.gestionprojet.pojo.TaskDTO;
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



    @GetMapping("/all")
    public List<ProjetDTO> listProjet(){
        List<Projet> projets=projetService.listProjet();
        return ObjectMapperUtils.mapAll(projets,ProjetDTO.class);
    }


    @GetMapping("/allProjetArchive")
    public List<ProjetDTO> listProjetArchive(){
        List<Projet> projets=projetService.listProjetArchive();
        return ObjectMapperUtils.mapAll(projets,ProjetDTO.class);
    }

    @PostMapping("/ajouter")
    public ProjetDTO ajouterProjet(@RequestBody ProjetDTO projetDTO){
        Projet projet=ObjectMapperUtils.map(projetDTO,Projet.class);
        Projet newProject=projetService.addProjet(projet);
        return ObjectMapperUtils.map(newProject,ProjetDTO.class);
    }

    @PutMapping("/{id}/modifier")
    public void modifierProjet(@PathVariable(name="id") Long id,@RequestBody ProjetDTO projetDTO){
        Projet projet=ObjectMapperUtils.map(projetDTO,Projet.class);
        projetService.editProjet(id,projet);
    }

    @PostMapping("/{id}/affecterResp")
    public void affecte(@PathVariable(name = "id") Long idProjet,@RequestBody ResponsableDTO responsableDTO){
        Responsable responsable=ObjectMapperUtils.map(responsableDTO,Responsable.class);
        projetService.affecterProjet(idProjet,responsable);
    }

    @PostMapping("archive/{id}")
    public void archive(@PathVariable(name = "id") Long id){
        projetService.archive(id);
    }

    @GetMapping("all/{id}")
    public Projet detailProjet(@PathVariable(name = "id") Long id){
        return projetService.getOne(id);
    }


    @PostMapping("/{id}/ajouterTask")
    public void ajouterTask(@PathVariable(name = "id") Long idprojet,@RequestBody TaskDTO taskDTO){
        Task task=ObjectMapperUtils.map(taskDTO,Task.class);
        projetService.ajouterTAskToProjet(idprojet,task);
    }









}
