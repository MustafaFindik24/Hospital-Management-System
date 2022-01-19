package SpringCRUD.HospitalManagement.Repository;

import SpringCRUD.HospitalManagement.Model.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {
    
}
