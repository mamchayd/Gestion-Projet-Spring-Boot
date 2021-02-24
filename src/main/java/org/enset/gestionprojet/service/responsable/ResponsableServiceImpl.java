package org.enset.gestionprojet.service.responsable;

import org.enset.gestionprojet.model.Responsable;
import org.enset.gestionprojet.pojo.ResponsableDTO;
import org.enset.gestionprojet.repositories.ResponsableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsableServiceImpl implements IResponsableService{

    @Autowired
    private ResponsableRepository responsableRepository;

    @Override
    public void addResponsable(Responsable responsable) {

        responsableRepository.save(responsable);

    }

    @Override
    public List<Responsable> responsables() {
        return responsableRepository.findAll();
    }

    @Override
    public Responsable editResponsable(Long id, Responsable responsable) {
        Responsable r=responsableRepository.findById(id).get();
        r.setNom(responsable.getEmail());
        r.setPrenom(responsable.getPrenom());
        r.setEmail(responsable.getEmail());
        responsableRepository.save(r);
        return r;
    }

    @Override
    public void deleteResponsable(Long id) {
        Responsable r=responsableRepository.findById(id).get();
        responsableRepository.delete(r);
    }
}
