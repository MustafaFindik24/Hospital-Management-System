package SpringCRUD.HospitalManagement.Repository;

import SpringCRUD.HospitalManagement.Model.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

}
