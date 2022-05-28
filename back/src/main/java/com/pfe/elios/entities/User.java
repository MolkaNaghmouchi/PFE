package com.pfe.elios.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private LocalDate starterDate;
    private String age;
    private String adresse;
    private String genre;
    private int num;
    private int nump;
    private String Cin;
    private String niveau;
    private String Salaire;
    @Lob
    private byte [] PhotoBytes;

    private String Role;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JsonIgnore
    @JsonManagedReference
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private List<RolesName> role_name = new ArrayList<RolesName>();

    /*@ManyToMany(mappedBy = "users")
    private Collection<Paiement> paiements;*/

   /* @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    Set<Formation> listeFormation;


  /*@OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE})
    private List<Quest_Pro> quest_pros=new ArrayList<>();
*/
   @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
   private Paiement paiement;



    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST})
    private List<Formation> formation=new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE})
    private List<Quest_Pro> quest_pros=new ArrayList<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    Set<Quiz> listeQuiz;

  /*      return listeFormation;
    }
    public void setListeFormation(Set<Formation> listeFormation) {
        this.listeFormation = listeFormation;
    }
*/












}
