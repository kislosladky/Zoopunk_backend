package zoopunk.backend.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.ColumnTransformer;

import java.util.List;
import java.util.UUID;

@Entity(name="users")
public class User {
    public User() {}

    public User(UUID id,
                String firstName,
                String lastName,
                String nickname,
                int age,
                String quizProgress)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.age = age;
        this.quizProgress = null;
    }

    @Column(name="id")
    @Id
    private UUID id;

    @Column(name="firstname")
    private String firstName;

    @Column(name="lastname")
    private String lastName;

    @Column(name="nickname")
    private String nickname;

    @Column(name="age")
    private int age;

    @Column(name="quizprogress", columnDefinition = "json")
    @ColumnTransformer(write = "?::jsonb")
    private String quizProgress;
}
