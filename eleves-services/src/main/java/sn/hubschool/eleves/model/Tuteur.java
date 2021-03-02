package sn.hubschool.eleves.model;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

/**
 * Created by gueyealy on 02/01/2018.
 */
@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Tuteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    private String email;
    private String nomTuteur;
    private String prenomTuteur;
    private String adresse;
    private int telephone;

}
