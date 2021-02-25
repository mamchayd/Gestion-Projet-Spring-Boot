package org.enset.gestionprojet.repositories;


import org.enset.gestionprojet.model.Responsable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponsableRepository extends JpaRepository<Responsable,Long> {


    Responsable findResponsableByEmail(Long id);
}
