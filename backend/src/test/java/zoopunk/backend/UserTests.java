package zoopunk.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import zoopunk.backend.Entity.User;
import zoopunk.backend.EntityList.UserList;
import zoopunk.backend.Repository.UserRepository;

import java.lang.reflect.Array;
import java.net.URI;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class UserTests {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void findExistingPerson() {
        ResponseEntity<User> response = restTemplate
                .getForEntity("/user/userById?id=85557a27-6908-415f-ad16-e8f959871c54", User.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        User buddy = response.getBody();

        assertEquals(buddy.getFirstName(), "Олег");
    }

    @Test
    void findNobody() {
        UUID randomId = UUID.randomUUID();

        ResponseEntity<User> response = restTemplate
                .getForEntity("/user/byId?id=" + randomId, User.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void findListOfPersons() {
        ResponseEntity<UserList> response = restTemplate
                .getForEntity("/user/ageBetween?lowerAge=0&upperAge=10", UserList.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        List<User> users = response.getBody().getUserList();
        List<String> names = users.stream().map(User::getFirstName).toList();
        assertTrue(equalLists(names, List.of("Олег", "Антон", "Елизавета")));
    }

//    @Test
//    @DirtiesContext
//    void postUser() {
//        User user = new User(UUID.randomUUID(), "Илья", "Кислицын", "Хуй", 19, "abhui");
//        ResponseEntity<Void> postResponse = restTemplate.postForEntity("/user", user, Void.class);
//        assertEquals(HttpStatus.CREATED, postResponse.getStatusCode());
//
//        URI uri = postResponse.getHeaders().getLocation();
//        assertEquals("http://localhost:8080/user/userById%3Fid=" + user.getId(), uri.toString());
//        ResponseEntity<User> getResponse = restTemplate.getForEntity(uri, User.class);
//        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
//        assertEquals(user, getResponse.getBody());
//    }

    private boolean equalLists(List<String> arr1, List<String> arr2) {
        HashSet<String> set1 = new HashSet<>(arr1);
        HashSet<String> set2 = new HashSet<>(arr2);
        return set1.equals(set2);
    }
}
