package org.enset.gestionprojet.service.projet;

import org.enset.gestionprojet.model.Projet;
import org.enset.gestionprojet.model.Responsable;
import org.enset.gestionprojet.repositories.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetServiceImpl implements IProjetService{

    @Autowired
    ProjetRepository projetRepository;


    @Override
    public void addProjet(Projet projet) {
        projetRepository.save(projet);

    }

    @Override
    public Projet editProjet(Projet projet) {
        Projet p=projetRepository.findById(projet.getId()).get();
        p.setDateDebut(projet.getDateDebut());
        p.setDescription(projet.getDescription());
        p.setTitre(projet.getTitre());
        p.setStatus(projet.getStatus());
        p.setResponsable(projet.getResponsable());
        projetRepository.save(p);
        return p;
    }

    @Override
    public void archive(Projet projet) {
        Projet p=projetRepository.findById(projet.getId()).get();
        p.setArchive(true);
        projetRepository.save(p);
    }

    @Override
    public void affecterProjet(Projet projet, Responsable responsable) {
        Projet p=projetRepository.findById(projet.getId()).get();
        p.setResponsable(responsable);
        projetRepository.save(p);
    }

    @Override
    public List<Projet> listProjetArchive() {
        return projetRepository.listProjetArchive();
    }
}
