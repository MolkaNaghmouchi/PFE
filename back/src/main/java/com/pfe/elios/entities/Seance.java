package com.pfe.elios.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Seance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String titre;


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime date_debut;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime date_fin;
    @ManyToOne
    @JoinColumn(name="form_id")
    @JsonBackReference
    private Formation formation;




}
