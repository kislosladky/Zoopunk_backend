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
                  String name,
                  String animalclass,
                  String family,
                  String species,
                  String description,
                  String imgpath,
                  String background)
    {
        this.id = id;
        this.species = species;
        this.name = name;
        this.description = description;
        this.animalclass = animalclass;
        this.background = background;
        this.imgpath = imgpath;
        this.family = family;
    }


    @Column(name="id")
    @Id
    private UUID id;

    @Column(name="name")
    private String name;

    @Column(name="animalclass")
    private String animalclass;

    @Column(name="family")
    private String family;

    @Column(name="species")
    private String species;


    @Column(name="description", columnDefinition = "json")
    @ColumnTransformer(write = "?::jsonb")
    private String description;

    @Column(name="imgpath")
    private String imgpath;

    @Column(name="background")
    private String background;

    public String getAnimalclass() {
        return animalclass;
    }

    public void setAnimalclass(String animalclass) {
        this.animalclass = animalclass;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

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
