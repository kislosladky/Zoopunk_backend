package zoopunk.backend.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.ColumnTransformer;

import java.util.UUID;

@AllArgsConstructor
@Data
@Entity(name="animals")
public class Animal {
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

    @Column(name="latitude")
    private Float latitude;

    @Column(name="longitude")
    private Float longitude;
}
