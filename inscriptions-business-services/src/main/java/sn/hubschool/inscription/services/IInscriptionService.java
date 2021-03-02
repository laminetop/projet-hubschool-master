package sn.hubschool.inscription.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sn.hubschool.inscription.models.Inscription;

import java.util.List;

/**
 * Created by gueyealy on 18/12/2017.
 */
public interface IInscriptionService {

    Page<Inscription> findByAnnee(String annee,Pageable pageable);

    List<Inscription> findByEleve(Long idEleve);

    Inscription findFirstByEleveAndAnnee(Long idEleve, String annee);

    Page<Inscription> findByClasse(Long idClasse, Pageable pageable);

    Inscription create(String annee, Long idEleve, Long idClasse, Double montant);

     void supprimer(Long id);

    Page<Inscription> getInscriptions(Pageable pageable);

    Inscription validatePaiement(Long inscriptionId, double montant);

    List<Inscription> findByClasseAndAnnee(Long idClasse,String annee);

    Inscription  findByEleveAndAnnee(Long idEleve, String annee);

    Inscription findById(Long id);

}
