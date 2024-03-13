package zoopunk.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zoopunk.backend.Entity.AchievementProgress;

import java.util.UUID;

public interface AchievementProgressRepository extends JpaRepository<AchievementProgress, UUID> {
}
