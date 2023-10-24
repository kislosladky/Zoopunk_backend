package zoopunk.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

@SpringBootTest
class ZoopunkBackendApplicationTests {
	@Autowired
	UserRepository userRepo;
	@Test
	void contextLoads() {
		List<User> allById = userRepo.findAllById(Collections.emptyList());
	}

}
