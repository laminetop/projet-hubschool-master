package sn.hubschool.inscription.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sn.hubschool.inscription.models.Inscription;


import javax.persistence.Query;
import java.util.List;

/**
 * Created by gueyealy on 10/12/2017.
 */
@RepositoryRestResource(exported = false)
public interface InscriptionRepository extends PagingAndSortingRepository<Inscription,Long>{
    List<Inscription> findByEleve(Long idEleve);

    Inscription findFirstByEleveAndAnnee(Long idEleve,String annee);

    Page<Inscription> findByAnnee(String annee,Pageable pageable);

    Page<Inscription> findByClasse(Long idClasse, Pageable pageable);

    List<Inscription> findByClasseAndAnnee(Long idClasse,String annee);

    Inscription findById(Long id);
}
