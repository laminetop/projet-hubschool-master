package sn.hubschool.ecoles.model;


import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by gueyealy on 10/12/2017.
 */
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Professeur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private int telephone;
    @ManyToOne
    private Ecole ecole;

}
