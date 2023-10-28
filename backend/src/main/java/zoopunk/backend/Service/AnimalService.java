package zoopunk.backend.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zoopunk.backend.Repository.AnimalRepository;
import zoopunk.backend.Entity.Animal;

import java.util.Collections;

//import java.util.Collections;
 import java.util.List;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public void example() {
        animalRepository.findAllById(Collections.emptyList());
    }

    public List<String> getNameBySpecies(String species) {
        List<String> response = animalRepository.findAllNamesBySpecies(species);
        return response;
    }

}
