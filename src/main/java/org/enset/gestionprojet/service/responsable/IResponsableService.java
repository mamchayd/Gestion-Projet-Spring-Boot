package org.enset.gestionprojet.service.responsable;

import org.enset.gestionprojet.model.Responsable;
import org.enset.gestionprojet.pojo.ResponsableDTO;

import java.util.List;

public interface IResponsableService {

    public void addResponsable(Responsable responsable);
    public List<Responsable> responsables ();
    public Responsable editResponsable(Long id, Responsable responsable);
    public void deleteResponsable(Long id);

}
