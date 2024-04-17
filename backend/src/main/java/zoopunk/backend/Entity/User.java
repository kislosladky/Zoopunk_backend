package zoopunk.backend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="users")
public class User {
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

    @Column(name="image")
    private String image;
}
