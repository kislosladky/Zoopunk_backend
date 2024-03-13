package zoopunk.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zoopunk.backend.Entity.Animal;
import zoopunk.backend.EntityList.AnimalList;
import zoopunk.backend.Service.AnimalService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/animal")
public class AnimalController {
    @Autowired
    AnimalService animalService;

    @GetMapping("/nameBySpecies")
    public ResponseEntity<AnimalList> getName(@RequestParam String species) {
        List<String> response = animalService.getNameBySpecies(species);

        if (!response.isEmpty()) {
            AnimalList animalList = new AnimalList();
//            animalList.setNames(response);
            return ResponseEntity.ok(animalList);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/entityById")
    public ResponseEntity<Animal> getAnimalsById(@RequestParam UUID id) {
        Optional<Animal> response = animalService.getAnimalById(id);
        return ResponseEntity.of(response);
    }

    @GetMapping("/all")
    public ResponseEntity<AnimalList> getAllAnimals() {
        List<Animal> response = animalService.getAllAnimals();

        if (!response.isEmpty()) {
            AnimalList animalList = new AnimalList();
            animalList.setAnimals(response);
            return ResponseEntity.ok(animalList);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
