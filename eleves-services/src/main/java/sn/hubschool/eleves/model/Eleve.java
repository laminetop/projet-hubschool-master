package sn.hubschool.eleves.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gueyealy on 02/01/2018.
 */
@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Eleve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String adresse;

    @Temporal(TemporalType.DATE)
    private Date date_naissance;
    private String matricule;
    private String nom;
    private String prenom;
    @ManyToOne
    private Tuteur tuteur;


}
