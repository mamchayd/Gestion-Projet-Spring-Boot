package org.enset.gestionprojet.service.task;

import org.enset.gestionprojet.model.Projet;
import org.enset.gestionprojet.model.Responsable;
import org.enset.gestionprojet.model.Task;


import java.util.List;

public interface ITaskService {

    public Task addTask(Task task);
    public List<Task> listTask ();
    public Task editTask(Long id,Task task);
    public void affecterTaskToResp(Long id,Responsable responsable);

    public Task getOne(Long id);
}
