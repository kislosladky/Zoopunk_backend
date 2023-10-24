package zoopunk.backend;

import org.hibernate.annotations.SQLSelect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.rmi.server.UID;
import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    List<User> findAllById(Iterable<UUID> uuids);

    @Query(nativeQuery = true, value = "SELECT * FROM USERS WHERE ID IN ?1")
    List<User> customSelect(Iterable<UUID> uuids);
    // делает все сам, имплементить ничего не надо
}
