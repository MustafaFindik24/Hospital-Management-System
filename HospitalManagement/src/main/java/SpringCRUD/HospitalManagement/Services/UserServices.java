package SpringCRUD.HospitalManagement.Services;

import SpringCRUD.HospitalManagement.Model.User;
import SpringCRUD.HospitalManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository repo;

    public List<User> listAll(){

        return (List<User>) repo.findAll();
    }
    public void save(User user) {

        repo.save(user);
    }

    public User get(Long id) {

        return repo.findById(id).get();
    }

    public void delete(Long id) {

        repo.deleteById(id);
    }

}
