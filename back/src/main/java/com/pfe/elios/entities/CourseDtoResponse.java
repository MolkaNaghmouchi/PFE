package com.pfe.elios.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CourseDtoResponse {
    private Long idFormation;
    private String nom_cour;
    private String niveau;
    private String formationName;
}
