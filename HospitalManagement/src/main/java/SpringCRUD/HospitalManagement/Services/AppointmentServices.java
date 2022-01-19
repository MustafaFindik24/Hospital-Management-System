package SpringCRUD.HospitalManagement.Services;


import SpringCRUD.HospitalManagement.Model.Appointment;
import SpringCRUD.HospitalManagement.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServices {
    @Autowired
    private AppointmentRepository appointmentRepo;

    public List<Appointment> listAll() {
        return (List<Appointment>) appointmentRepo.findAll();
    }

    public void save(Appointment appointment) {
        appointmentRepo.save(appointment);
    }

    public Appointment get(Long id) {
        return appointmentRepo.findById(id).get();
    }

    public void delete(Long id) {
        appointmentRepo.deleteById(id);
    }

}
