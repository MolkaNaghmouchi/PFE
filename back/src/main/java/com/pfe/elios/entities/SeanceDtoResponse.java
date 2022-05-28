package com.pfe.elios.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
public class SeanceDtoResponse {
    private String titre;
    private LocalDateTime date_debut;
    private LocalDateTime date_fin;
    private String formationName;
}
