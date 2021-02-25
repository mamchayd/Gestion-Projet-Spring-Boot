package org.enset.gestionprojet.service.projet;

import org.enset.gestionprojet.model.Projet;
import org.enset.gestionprojet.model.Responsable;

import java.util.List;


public interface IProjetService {

    /**
     * @param projet Projet
     */
    public Projet addProjet(Projet projet);
    public Projet editProjet(Long id,Projet projet);
    public void archive(Long id);
    public void affecterProjet(Long id, Responsable responsable);
    public List<Projet> listProjetArchive();
    public List<Projet> listProjet();
    public Projet getOne(Long id);


}
