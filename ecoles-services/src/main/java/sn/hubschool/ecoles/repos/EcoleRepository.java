package sn.hubschool.ecoles.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import sn.hubschool.ecoles.model.Ecole;






@RepositoryRestResource(path = "ecoles",collectionResourceRel = "ecoles")
@CrossOrigin("*")
public interface EcoleRepository extends PagingAndSortingRepository<Ecole,Long>{
  Page<Ecole> findByTypeecole(@Param("typeecole") String typeecole, Pageable pageable);
}
