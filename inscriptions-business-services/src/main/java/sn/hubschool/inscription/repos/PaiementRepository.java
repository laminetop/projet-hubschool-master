package sn.hubschool.inscription.repos;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sn.hubschool.inscription.models.Paiement;

@RepositoryRestResource(exported = false)
public interface PaiementRepository  extends PagingAndSortingRepository<Paiement,Long> {
}
