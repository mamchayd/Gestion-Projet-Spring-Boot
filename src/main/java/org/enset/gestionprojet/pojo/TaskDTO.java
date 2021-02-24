package org.enset.gestionprojet.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class TaskDTO {
    private Long id;
    private String titre;
    private String decription;
    private Date dateDebut;
    private Date datecreation;
    private double duree;
    private ResponsableDTO responsable;

}
