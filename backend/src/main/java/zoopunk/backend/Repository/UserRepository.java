package zoopunk.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import zoopunk.backend.Entity.User;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    List<User> findAllById(Iterable<UUID> uuids);

    @Query(nativeQuery = true, value = "SELECT * FROM USERS WHERE ID IN ?1")
    List<User> customSelect(Iterable<UUID> uuids);
    // делает все сам, имплементить ничего не надо


    List<User> findByAgeBetween(Integer lower, Integer upper);
}
