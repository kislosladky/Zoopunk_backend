package zoopunk.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import zoopunk.backend.Entity.QuizProgress;
import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.util.UUID;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QuizProgressTest {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void postAndGetProgress() {
        QuizProgress quizProgress = new QuizProgress(UUID.fromString("85557a27-6908-415f-ad16-e8f959871c54"),
                UUID.fromString("45851e4e-7d4f-4e22-b8b4-cccbbbeba3ad"), 12);

        ResponseEntity<String> createResponse = restTemplate.postForEntity("/quizProgress", quizProgress, String.class);

        assertEquals(HttpStatus.NO_CONTENT, createResponse.getStatusCode());

//        URI location = createResponse.getHeaders().getLocation();

    }
}
