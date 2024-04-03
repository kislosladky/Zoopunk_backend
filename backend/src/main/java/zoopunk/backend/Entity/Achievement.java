package zoopunk.backend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name="achievements")
public class Achievement {

    @Column(name="id")
    @Id
    private UUID id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="pointsfordone")
    private int pointsfordone;
}
