package sn.hubschool.users.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.hubschool.users.models.Authoritie;

@RepositoryRestResource
public interface AuthoritieRepository extends JpaRepository<Authoritie, Long> {
}
