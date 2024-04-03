package zoopunk.backend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.ColumnTransformer;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="quizzes")
public class Quiz {

    @Column(name="id")
    @Id
    private UUID id;

    @Column(name="achievementsid")
    private UUID achievementsId;

    @Column(name="name")
    private String name;


    @Column(name="img")
    private String img;

    @Column(name="description")
    private String description;

    @Column(name="quizcontent", columnDefinition = "json")
    @ColumnTransformer(write = "?::jsonb")
    private String quizContent;
}
