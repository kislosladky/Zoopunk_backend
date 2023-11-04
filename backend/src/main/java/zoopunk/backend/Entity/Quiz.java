package zoopunk.backend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Quiz {
    @Column(name="id")
    @Id
    private UUID id;

    @Column(name="quizContent")
    private String quizContent;
}
