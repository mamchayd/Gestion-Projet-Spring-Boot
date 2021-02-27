package org.enset.gestionprojet.controller;

import org.enset.gestionprojet.configuration.ObjectMapperUtils;
import org.enset.gestionprojet.model.Projet;
import org.enset.gestionprojet.model.Responsable;
import org.enset.gestionprojet.model.Task;
import org.enset.gestionprojet.pojo.ProjetDTO;
import org.enset.gestionprojet.pojo.ResponsableDTO;
import org.enset.gestionprojet.pojo.TaskDTO;
import org.enset.gestionprojet.service.responsable.ResponsableServiceImpl;
import org.enset.gestionprojet.service.task.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskServiceImpl taskService;

    @Autowired
    ResponsableServiceImpl responsableService;




    @PutMapping("/{id}/modifier")
    public void modifierTask(@PathVariable(name="id") Long id,@RequestBody TaskDTO taskDTO){
        Task task=ObjectMapperUtils.map(taskDTO,Task.class);
        taskService.editTask(id,task);
    }

    @PostMapping("/{id}/affecterResp")
    public void affecte(@PathVariable(name = "id") Long idTask,@RequestBody ResponsableDTO responsableDTO){
        Responsable responsable=ObjectMapperUtils.map(responsableDTO,Responsable.class);
        taskService.affecterTaskToResp(idTask,responsable);
    }




}
