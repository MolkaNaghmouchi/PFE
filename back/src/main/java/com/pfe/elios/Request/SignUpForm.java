package com.pfe.elios.Request;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class SignUpForm {
    private Long id ;
    private String firstName ;
    private String lastName;
    private String email ;
    private int Num ;
    private int nump;
    private String genre ;
    private String username ;
    private String password ;
    private String adresse;
    private String Cin;
    private String niveau;
    private String age;
    private String Salaire;
    private String role;

}
