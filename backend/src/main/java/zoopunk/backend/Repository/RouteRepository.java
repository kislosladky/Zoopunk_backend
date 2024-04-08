package zoopunk.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zoopunk.backend.Entity.Route;
import java.util.UUID;

@Repository
public interface RouteRepository extends JpaRepository<Route, UUID> {
}
