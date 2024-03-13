package zoopunk.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zoopunk.backend.Entity.QuizProgress;

import java.util.UUID;

public interface QuizProgressRepository extends JpaRepository<QuizProgress, UUID> {
}
