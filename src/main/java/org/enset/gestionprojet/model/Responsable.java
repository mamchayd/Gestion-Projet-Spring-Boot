package org.enset.gestionprojet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Responsable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String tel;
    private String email;

    @OneToMany(mappedBy = "responsable",cascade = CascadeType.ALL)
    private List<Task> tasks;
    @OneToMany(mappedBy = "responsable",cascade = CascadeType.ALL)
    private List<Project> projects;
}
