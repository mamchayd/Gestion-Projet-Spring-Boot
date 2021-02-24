package org.enset.gestionprojet.service.task;

import org.enset.gestionprojet.model.Responsable;
import org.enset.gestionprojet.model.Task;


import java.util.List;

public interface ITaskService {

    public void addTask(Task task);
    public List<Task> listTask ();
    public Task editTask(Task task);
    public void affecterTask(Task task,Responsable responsable);
}
