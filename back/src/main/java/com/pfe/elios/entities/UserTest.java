package com.pfe.elios.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserTest {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate starterDate;
    private int nump;
    private String age;
    @Lob
    private byte[] image;
    private String Username;

    private String adresse;
    private String genre;
    private int num;
    private byte[] PhotoBytes;
    private String imageUrl;
    private String Cin;
    private String niveau;
    private String nommatiere;
    private String Salaire;
    private String role;
    private String fileName;
    private String downloadUri;
    private long size;
    private List<Role> roleList=new ArrayList<>();
}

