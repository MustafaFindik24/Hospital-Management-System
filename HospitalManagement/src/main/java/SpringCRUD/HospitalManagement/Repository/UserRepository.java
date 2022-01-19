package SpringCRUD.HospitalManagement.Repository;

import SpringCRUD.HospitalManagement.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u Where u.username = :username")
    public User getUserByUsername(@Param("username") String username);

   

}
