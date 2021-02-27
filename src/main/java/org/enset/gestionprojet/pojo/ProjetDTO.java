package org.enset.gestionprojet.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.enset.gestionprojet.model.Status;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Data
public class ProjetDTO {

    private Long id;
    private String titre;
    private String description;
    @JsonIgnore
    private Date dateCreation;
    private Date dateDebut;
    private double duree;
    private ResponsableDTO responsable;
    private List<TaskDTO> tasks;
    private Status status;
    private boolean isArchive=false;



}
