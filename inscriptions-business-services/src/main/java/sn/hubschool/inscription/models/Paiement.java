package sn.hubschool.inscription.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by gueyealy on 09/01/2018.
 */
@Entity

@Data @NoArgsConstructor @AllArgsConstructor
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lebellePaiement;

    private String codeTransaction;

    private Date date;

      @OneToMany
     private List<Inscription> inscription;

}
