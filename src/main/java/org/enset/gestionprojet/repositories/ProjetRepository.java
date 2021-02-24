package org.enset.gestionprojet.repositories;

import org.enset.gestionprojet.model.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ProjetRepository extends JpaRepository<Projet,Long> {
    @Query("SELECT p FROM Projet p WHERE p.isArchive = true")
    public List<Projet> listProjetArchive();
}
