package sn.hubschool.ecoles.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sn.hubschool.ecoles.model.Professeur;


/**
 * Created by gueyealy on 10/12/2017.
 */
@RepositoryRestResource(path = "professeurs",collectionResourceRel = "professeurs")
public interface ProfesseurRepository extends PagingAndSortingRepository<Professeur,Long>{
Page<Professeur> findByEcoleId(@Param("idEcole") Long id,Pageable pageable);
}
