package org.enset.gestionprojet.pojo;

import lombok.Data;
import org.enset.gestionprojet.model.Status;

import java.util.Date;

@Data
public class TaskDTO {
    private Long id;
    private String titre;
    private String description;
    private Date dateDebut;
    private double duree;
    private ResponsableDTO responsable;
    private ProjetDTO projetDTO;
    public Status status;


}

