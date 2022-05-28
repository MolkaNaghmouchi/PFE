package com.pfe.elios.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PaiementDtoResponse {
    private  Long id;
    private LocalDate date_paiement;
    private int Montant;
    private String Mois;
  //  private String Eleve;
    private String eleveName;
}
