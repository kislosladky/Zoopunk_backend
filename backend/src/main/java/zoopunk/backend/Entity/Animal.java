package zoopunk.backend.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity(name="ANIMALS")
public class Animal {
    @Column(name="ID")
    @Id
    private UUID id;

    @Column(name="SPECIES")
    private String species;

    @Column(name="NAME")
    private String name;

    @Column(name="DESCRIPTION")
    private String description;
}
