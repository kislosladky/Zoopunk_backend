package zoopunk.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import zoopunk.backend.Controller.UserController;
import zoopunk.backend.Entity.Quiz;
import zoopunk.backend.Entity.User;
import zoopunk.backend.Repository.QuizRepository;
import zoopunk.backend.Repository.UserRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QuizTests {
    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    QuizRepository quizRepo;

    @Test
    void findQuizById() {
        ResponseEntity<String> response = restTemplate
                .getForEntity("/quiz/byId?id=45851e4e-7d4f-4e22-b8b4-cccbbbeba3ad", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void findAllQuizzes() {
        ResponseEntity<String[]> response = restTemplate
                .getForEntity("/quiz/all", String[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        String[] allQuizzes = response.getBody();

        assertEquals(allQuizzes.length, 1);
    }
}
