package zoopunk.backend.Repository;

import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import zoopunk.backend.Entity.User;

import java.util.List;
import java.util.UUID;

@Repository
@Table(name="users", schema = "public")
public interface UserRepository extends JpaRepository<User, UUID> {

    List<User> findAllById(Iterable<UUID> uuids);

    @Query(nativeQuery = true, value = "SELECT * FROM USERS")
    List<User> customSelect();
    // делает все сам, имплементить ничего не надо
}
