package sn.hubschool.inscription.domain;


import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * Created by gueyealy on 10/12/2017.
 */

@Data
public class InscriptionDto {

    @NotNull
    private Long idEleve;
    @NotNull
    private Long idClasse;
    @NotNull
    private String annee;
    @NotNull
    private Double montant;


}
