package zoopunk.backend.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;
import java.util.UUID;

@Entity(name="USERS")
public class User {
    @Column(name="ID")
    @Id
    private UUID id;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="NICKNAME")
    private String nickname;

    @Column(name="AGE")
    private int age;

    @Column(name="QUIZ_PROGRESS")
    private String quizProgress;
}
