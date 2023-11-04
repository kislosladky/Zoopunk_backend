package zoopunk.backend.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity(name="animals")
public class Animal {
    @Column(name="id")
    @Id
    private UUID id;

    @Column(name="species")
    private String species;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;
}
