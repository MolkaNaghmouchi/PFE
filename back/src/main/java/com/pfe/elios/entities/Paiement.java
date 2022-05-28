package com.pfe.elios.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idPay;
    private LocalDate date_paiement;
    private int Montant;
    private String Mois;

    private String etatDePayment ;
    private String UserName;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private User user;



}
