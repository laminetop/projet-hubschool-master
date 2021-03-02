package sn.hubschool.ecoles.model;


import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Classe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private int capacite;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Ecole ecole;

}
