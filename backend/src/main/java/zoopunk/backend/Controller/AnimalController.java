package zoopunk.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zoopunk.backend.Entity.Animal;
import zoopunk.backend.Service.AnimalService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/animal")
public class AnimalController {
    @Autowired
    AnimalService animalService;

    @GetMapping("/bySpecies")
    public ResponseEntity<List<String>> getName(@RequestParam String species) {
        List<String> response = animalService.getNameBySpecies(species);
        if (!response.isEmpty()) {
            return ResponseEntity.ok(response);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/byId")
    public ResponseEntity<Animal> getAnimalsById(@RequestParam UUID id) {
        Optional<Animal> response = animalService.getAnimalById(id);
        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Animal>> getAllAnimals() {
        List<Animal> response = animalService.getAllAnimals();
        if (!response.isEmpty()) {
            return ResponseEntity.ok(response);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
