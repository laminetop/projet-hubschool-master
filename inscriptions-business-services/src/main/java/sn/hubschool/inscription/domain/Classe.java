package sn.hubschool.inscription.domain;


import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by gueyealy on 10/12/2017.
 */

@Data
public class Classe {


    private Long id;


    private String nom;

}
