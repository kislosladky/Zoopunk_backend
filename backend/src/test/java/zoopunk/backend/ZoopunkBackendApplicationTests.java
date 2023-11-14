package zoopunk.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import zoopunk.backend.Controller.UserController;
import zoopunk.backend.Entity.User;
import zoopunk.backend.Repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ZoopunkBackendApplicationTests {
	@Autowired
	TestRestTemplate restTemplate;

	@Test
	void findOleg() {
		ResponseEntity<User> response = restTemplate
				.getForEntity("/user/byId?id=85557a27-6908-415f-ad16-e8f959871c54", User.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void findNobody() {
		UUID randomId = UUID.randomUUID();

		ResponseEntity<User> response = restTemplate
				.getForEntity("/user/byId?id=" + randomId.toString(), User.class);

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}



}
