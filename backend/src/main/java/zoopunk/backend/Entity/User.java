package zoopunk.backend.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;
import java.util.UUID;

@Entity(name="users")
public class User {
    @Column(name="id")
    @Id
    private UUID id;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="nickname")
    private String nickname;

    @Column(name="age")
    private int age;

    @Column(name="quizProgress")
    private String quizProgress;

    //структура таблицы без методов
}
