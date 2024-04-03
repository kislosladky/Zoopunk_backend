package zoopunk.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import zoopunk.backend.EntityList.AchievementList;

import java.util.List;

import zoopunk.backend.dto.AchievementDto;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AchievementTests {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void testAllAchievements() {
        ResponseEntity<AchievementList> response = restTemplate
                .getForEntity("/achievement/all", AchievementList.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        List<AchievementDto> achievements = response.getBody().getAchievements();
        assertEquals(2, achievements.size());
    }
}
