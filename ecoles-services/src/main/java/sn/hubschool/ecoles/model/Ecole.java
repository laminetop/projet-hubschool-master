package sn.hubschool.ecoles.model;


import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by gueyealy on 10/12/2017.
 */
@Entity
@NoArgsConstructor @AllArgsConstructor
@Data
public class Ecole implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String adresse;
    private String typeecole;
}
