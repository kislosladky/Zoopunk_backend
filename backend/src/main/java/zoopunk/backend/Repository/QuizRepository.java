package zoopunk.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zoopunk.backend.Entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, UUID> {
    List<Quiz> findAllById(Iterable<UUID> uuids);

    String findQuizById(UUID uuid);

}
