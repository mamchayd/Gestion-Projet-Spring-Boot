package org.enset.gestionprojet.service.task;


import org.enset.gestionprojet.model.Responsable;
import org.enset.gestionprojet.model.Task;
import org.enset.gestionprojet.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskServiceImpl implements ITaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public void addTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public List<Task> listTask() {
        return taskRepository.findAll();
    }

    @Override
    public Task editTask(Task task) {
        Task t=taskRepository.findById(task.getId()).get();
        t.setTitre(task.getTitre());
        t.setDecription(task.getDecription());
        t.setDuree(task.getDuree());
        t.setResponsable(task.getResponsable());
        t.setDateDebut(task.getDateDebut());
        t.setStatus(task.getStatus());
        taskRepository.save(t);
        return t;
    }

    @Override
    public void affecterTask(Task task, Responsable responsable) {
        Task t=taskRepository.findById(task.getId()).get();
        t.setResponsable(responsable);
        taskRepository.save(t);
    }
}
