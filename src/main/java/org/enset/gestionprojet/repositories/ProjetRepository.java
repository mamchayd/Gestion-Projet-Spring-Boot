package org.enset.gestionprojet.repositories;

import org.enset.gestionprojet.model.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProjetRepository extends JpaRepository<Projet,Long> {
}
