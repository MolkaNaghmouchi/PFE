package com.pfe.elios.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PaiementDto {

    private LocalDate date_paiement;
    private int Montant;
    private String Mois;
    private String etatDePayment;
    private Long id;
}
