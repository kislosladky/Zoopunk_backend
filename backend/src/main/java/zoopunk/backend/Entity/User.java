package zoopunk.backend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity(name="users")
public class User {
    public User() {}

    public User(UUID id,
                String firstName,
                String lastName,
                String nickname,
                int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.age = age;
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

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public int getAge() {
        return age;
    }

}
