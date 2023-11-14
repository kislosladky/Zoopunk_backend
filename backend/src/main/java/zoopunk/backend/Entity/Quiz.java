package zoopunk.backend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.ColumnTransformer;

import java.util.UUID;

@Entity(name="quizzes")
public class Quiz {
    public Quiz() {}

    public Quiz(UUID id, String quizContent) {
        this.id = id;
        this.quizContent = quizContent;
    }


    @Column(name="id")
    @Id
    private UUID id;

    @Column(name="quizcontent", columnDefinition = "json")
    @ColumnTransformer(write = "?::jsonb")
    private String quizContent;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getQuizContent() {
        return quizContent;
    }

    public void setQuizContent(String quizContent) {
        this.quizContent = quizContent;
    }
}
