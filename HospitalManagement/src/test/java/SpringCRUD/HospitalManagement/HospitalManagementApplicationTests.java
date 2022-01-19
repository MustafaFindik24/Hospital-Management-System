package SpringCRUD.HospitalManagement;

import SpringCRUD.HospitalManagement.Model.Role;
import SpringCRUD.HospitalManagement.Model.User;
import SpringCRUD.HospitalManagement.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HospitalManagementApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private UserRepository repo;

	@Test
	public void testCreateUser() {
		User user = new User();
		user.setUsername("Melih");
		user.setPassword("551066");
		user.setEnabled(true);
		repo.save(user);
	}

}
