package sn.hubschool.inscription.domain;


import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by gueyealy on 10/12/2017.
 */


@Data
public class Tuteur {

    private Long id;

    private String email;


    private String nom;


    private String prenom;


    private String adresse;


    private Date dateNaissance;

    private int telephone;
}
