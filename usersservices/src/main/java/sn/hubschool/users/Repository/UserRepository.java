package sn.hubschool.users.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import sn.hubschool.users.models.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
}
