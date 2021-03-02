package sn.hubschool.eleves.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sn.hubschool.eleves.model.Eleve;

/**
 * Created by gueyealy on 02/01/2018.
 */
@RepositoryRestResource(path = "eleves",collectionResourceRel = "eleves")
public interface EleveRepository  extends PagingAndSortingRepository<Eleve,Long> {
}
