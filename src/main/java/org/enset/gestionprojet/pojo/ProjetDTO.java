package org.enset.gestionprojet.pojo;

import lombok.Data;
import org.enset.gestionprojet.model.Status;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class ProjetDTO {

    private Long id;
    private String titre;
    private String description;
    private Date dateCreation;
    private Date dateDebut;
    private double duree;
    private ResponsableDTO responsable;
    public Status status;
    private boolean isArchive=false;

}
