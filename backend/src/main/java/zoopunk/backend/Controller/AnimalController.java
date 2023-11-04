package zoopunk.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public void getName(@RequestParam String species) {
        List<String> response = animalService.getNameBySpecies(species);
    }
}
