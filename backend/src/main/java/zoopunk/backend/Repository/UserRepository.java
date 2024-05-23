package zoopunk.backend.Repository;

import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import zoopunk.backend.Entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    List<User> findAllById(Iterable<UUID> uuids);

    @Query(nativeQuery = true, value = "SELECT * FROM USERS")
    List<User> customSelect();
    // делает все сам, имплементить ничего не надо
}
