package org.enset.gestionprojet.service.projet;

import org.enset.gestionprojet.model.Projet;
import org.enset.gestionprojet.model.Responsable;
import org.enset.gestionprojet.model.Task;
import org.enset.gestionprojet.repositories.ProjetRepository;
import org.enset.gestionprojet.repositories.ResponsableRepository;
import org.enset.gestionprojet.service.task.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjetServiceImpl implements IProjetService{

    @Autowired
    ProjetRepository projetRepository;
    @Autowired
    ResponsableRepository responsableRepository;
    @Autowired
    TaskServiceImpl taskService;


    @Override
    public Projet addProjet(Projet projet) {
        Projet p=projetRepository.save(projet);
        return p;
    }

    @Override
    public Projet editProjet(Long id,Projet projet) {
        Projet p=projetRepository.findById(id).get();
        p.setDateDebut(projet.getDateDebut());
        p.setDescription(projet.getDescription());
        p.setTitre(projet.getTitre());
        p.setStatus(projet.getStatus());
        p.setResponsable(projet.getResponsable());
        p.setTasks(projet.getTasks());
        projetRepository.save(p);
        return p;
    }

    @Override
    public void archive(Long id) {
        Projet p=projetRepository.findById(id).get();
        p.setArchive(true);
        projetRepository.save(p);
    }

    @Override
    public void affecterProjet(Long id, Responsable responsable) {
        Projet p=projetRepository.findById(id).get();
        p.setResponsable(responsable);
        projetRepository.save(p);

    }

    @Override
    public void ajouterTAskToProjet(Long id, Task task) {
        Projet p=projetRepository.findById(id).get();
        task.setProjet(p);
        p.addTask(task);
        projetRepository.save(p);
    }

    @Override
    public List<Projet> listProjetArchive() {
        return projetRepository.listProjetArchive();
    }

    @Override
    public List<Projet> listProjet() {
        return projetRepository.findAll();
    }

    @Override
    public Projet getOne(Long id) {
        return projetRepository.findById(id).get();
    }


}
