package zoopunk.backend.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.ColumnTransformer;

import java.util.UUID;

@Entity(name="animals")
public class Animal {
    public Animal() {}

    public Animal(UUID id,
                  String species,
                  String name,
                  String description)
    {
        this.id = id;
        this.species = species;
        this.name = name;
        this.description = description;
    }


    @Column(name="id")
    @Id
    private UUID id;

    @Column(name="species")
    private String species;

    @Column(name="name")
    private String name;

    @Column(name="description", columnDefinition = "json")
    @ColumnTransformer(write = "?::jsonb")
    private String description;
}
