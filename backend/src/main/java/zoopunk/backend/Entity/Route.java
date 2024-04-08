package zoopunk.backend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnTransformer;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name="routes")
public class Route {
    @Id
    @Column(name="id")
    private UUID id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="waypoints", columnDefinition = "json")
    @ColumnTransformer(write = "?::jsonb")
    private String waypoints;
}
