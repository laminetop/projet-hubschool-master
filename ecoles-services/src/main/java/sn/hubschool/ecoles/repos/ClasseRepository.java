package sn.hubschool.ecoles.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sn.hubschool.ecoles.model.Classe;


/**
 * Created by gueyealy on 10/12/2017.
 */
@RepositoryRestResource(path = "classes", collectionResourceRel = "classes")
public interface ClasseRepository extends PagingAndSortingRepository<Classe, Long> {
}
