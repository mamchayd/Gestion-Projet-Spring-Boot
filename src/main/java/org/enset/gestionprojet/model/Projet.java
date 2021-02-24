package org.enset.gestionprojet.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Projet {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String titre;
    private String description;
    private boolean isArchive=false;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dateCreation;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dateDebut;
    private double duree;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @ManyToOne
    @JsonIgnore
    private Responsable responsable;

}
