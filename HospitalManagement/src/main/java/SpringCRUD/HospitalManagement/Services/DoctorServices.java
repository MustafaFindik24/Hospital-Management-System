package SpringCRUD.HospitalManagement.Services;

import SpringCRUD.HospitalManagement.Model.Doctor;
import SpringCRUD.HospitalManagement.Repository.DoctorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServices {

    @Autowired
    private DoctorRepository doctorRepo;

    public List<Doctor> listAll() { return (List<Doctor>) doctorRepo.findAll();}

    public void save(Doctor doctor) { doctorRepo.save(doctor); }

    public Doctor get(Long id) {
        return doctorRepo.findById(id).get();
    }

    public void delete(Long id) {
        doctorRepo.deleteById(id);
    }


}
