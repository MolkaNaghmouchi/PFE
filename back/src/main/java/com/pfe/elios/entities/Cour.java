package com.pfe.elios.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity

public class Cour{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom_cour;
    private String niveau;

    //private Long IdFormation;

   /* @Lob
    private byte[] data;*/

  /*@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
        @JoinTable(name = "Inscription",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_cour"))
    private List<User> users = new ArrayList<User>();*/
  /*@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
   @JsonIgnore
   @JsonManagedReference
   @JoinTable(name = "user_cour",
           joinColumns = @JoinColumn(name = "id"),
           inverseJoinColumns = @JoinColumn(name = "id_user"))
   private List<User> users = new ArrayList<User>();*/


    // private Set<Formation> formations=new HashSet<>();

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="formation_id")
    private Formation formation;

   /* @OneToMany(mappedBy ="cour" ,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE},fetch = FetchType.EAGER)
    private Set<Seance> seances;*/




}
