package zoopunk.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zoopunk.backend.Service.AnimalService;

import java.util.List;

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




}
