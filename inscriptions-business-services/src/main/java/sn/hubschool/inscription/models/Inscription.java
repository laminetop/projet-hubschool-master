package sn.hubschool.inscription.models;


import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import sn.hubschool.inscription.controllers.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by gueyealy on 10/12/2017.
 */
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Inscription implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String annee;
    private Double montant;
    private Long eleve;
    private Long classe;
    private Date date;
    private Status status;



}
