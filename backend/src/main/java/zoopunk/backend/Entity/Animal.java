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


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
