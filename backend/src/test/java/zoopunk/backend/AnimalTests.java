package zoopunk.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import zoopunk.backend.Entity.Animal;
import zoopunk.backend.Entity.User;
import zoopunk.backend.EntityList.AnimalList;
import zoopunk.backend.Repository.AnimalRepository;
import zoopunk.backend.Repository.UserRepository;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AnimalTests {
    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    AnimalRepository animalRepo;

    @Test
    void findStreetDogs() {
        ResponseEntity<AnimalList> response = restTemplate
                .getForEntity("/animal/getNameBySpecies", AnimalList.class);
    }

    @Test
    void findBobikById() {
        ResponseEntity<Animal> response = restTemplate
                .getForEntity("/animal/entityById?id=5ca96c26-afc8-4900-929e-9ae6bdb8d9dc", Animal.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        Animal bobik = response.getBody();

        assertEquals("Бобик", bobik.getName());
    }

    @Test
    void findNobody() {
        ResponseEntity<Animal> response = restTemplate
                .getForEntity("/animal/entityById?id=" + UUID.randomUUID(), Animal.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void findAllAnimals() {
        ResponseEntity<AnimalList> response = restTemplate
                .getForEntity("/animal/all", AnimalList.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        AnimalList animals = response.getBody();

        List<String> names = animals.getAnimals().stream().map(Animal::getName).toList();

        assertTrue(equalLists(names, List.of("Бобик", "Шарик", "Мурзик")));
    }


    private boolean equalLists(List<String> arr1, List<String> arr2) {
        HashSet<String> set1 = new HashSet<>(arr1);
        HashSet<String> set2 = new HashSet<>(arr2);
        return set1.equals(set2);
    }
}
