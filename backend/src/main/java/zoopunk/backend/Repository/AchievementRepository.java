package zoopunk.backend.Repository;

import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zoopunk.backend.Entity.Achievement;

import java.util.UUID;

@Repository
@Table(name="achievements", schema = "public")
public interface AchievementRepository extends JpaRepository<Achievement, UUID> {
}
