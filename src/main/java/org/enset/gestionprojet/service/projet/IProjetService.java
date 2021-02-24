package org.enset.gestionprojet.service.projet;

import org.enset.gestionprojet.model.Projet;
import org.enset.gestionprojet.model.Responsable;

import java.util.List;


public interface IProjetService {

    /**
     * @param projet Projet
     */
    public void addProjet(Projet projet);
    public Projet editProjet(Projet projet);
    public void archive(Projet p);
    public void affecterProjet(Projet p, Responsable responsable);
    public List<Projet> listProjetArchive();

}
