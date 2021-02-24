package org.enset.gestionprojet.repositories;


import org.enset.gestionprojet.model.Responsable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ResponsableRepository extends JpaRepository<Responsable,Long> {

}
