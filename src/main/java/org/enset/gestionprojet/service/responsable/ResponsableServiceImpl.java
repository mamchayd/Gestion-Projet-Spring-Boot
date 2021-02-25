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
    public Responsable addResponsable(Responsable responsable) {

        Responsable s=responsableRepository.save(responsable);
        return s;
    }

    @Override
    public List<Responsable> responsables() {
        return responsableRepository.findAll();
    }

    @Override
    public Responsable editResponsable(Long id,Responsable responsable) {
        Responsable r=responsableRepository.findById(id).get();
        r.setNom(responsable.getNom());
        r.setPrenom(responsable.getPrenom());
        r.setTel(responsable.getTel());

        return responsableRepository.save(r);
    }

    @Override
    public void deleteResponsable(Long id) {
        Responsable r=responsableRepository.findById(id).get();
        responsableRepository.delete(r);
    }

    @Override
    public Responsable getOne(Long id) {
        System.out.println("---------------getOne-------- "+id);
        Responsable r= responsableRepository.findById(id).get();
        System.out.println("---------------getOne-------- "+r.getNom());
        return r;
    }
}
