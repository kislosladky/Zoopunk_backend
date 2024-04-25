package zoopunk.backend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity(name="quizprogress")
public class QuizProgress {
    @Column(name="userid")
    @Id
    private UUID userid;

    @Column(name="quizid")
    private UUID quizid;

    @Column(name="quizresult")
    private int quizResult;
}
