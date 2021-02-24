package org.enset.gestionprojet.repositories;

import org.enset.gestionprojet.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TaskRepository extends JpaRepository<Task,Long> {
}
