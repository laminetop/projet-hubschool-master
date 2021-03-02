package sn.hubschool.inscription.domain;


import lombok.Data;

import java.util.Date;


/**
 * Created by gueyealy on 10/12/2017.
 */
    @Data
public class Eleve {


    private Long id;


    private String nom;


    private String prenom;

    private String matricule;


    private String adresse;


    private Date dateNaissance;


   private Tuteur tuteur;
}
