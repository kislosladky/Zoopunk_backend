package zoopunk.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import zoopunk.backend.Entity.Animal;

import java.util.List;
import java.util.UUID;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, UUID> {
    List<Animal> findAllById(Iterable<UUID> uuids);

    List<String> findAllNamesBySpecies(String species);

}
