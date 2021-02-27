package org.enset.gestionprojet.service.task;


import org.enset.gestionprojet.model.Projet;
import org.enset.gestionprojet.model.Responsable;
import org.enset.gestionprojet.model.Task;
import org.enset.gestionprojet.repositories.ResponsableRepository;
import org.enset.gestionprojet.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskServiceImpl implements ITaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ResponsableRepository responsableRepository;

    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> listTask() {
        return taskRepository.findAll();
    }

    @Override
    public Task editTask(Long id,Task task) {
        Task t=taskRepository.findById(id).get();
        t.setTitre(task.getTitre());
        t.setDescription(task.getDescription());
        t.setDuree(task.getDuree());
        t.setResponsable(task.getResponsable());
        t.setDateDebut(task.getDateDebut());
        t.setStatus(task.getStatus());
        taskRepository.save(t);
        return t;
    }

    @Override
    public void affecterTaskToResp(Long id, Responsable responsable) {
        Task t=taskRepository.findById(id).get();
        t.setResponsable(responsable);
        taskRepository.save(t);
    }


    @Override
    public Task getOne(Long id) {
        return taskRepository.findById(id).get();
    }
}
