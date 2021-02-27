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
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dateDebut;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dateCreation;

    private double duree;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @ManyToOne
    @JsonIgnore
    private Responsable responsable;

    @ManyToOne
    @JsonIgnore
    private Projet projet;



}
