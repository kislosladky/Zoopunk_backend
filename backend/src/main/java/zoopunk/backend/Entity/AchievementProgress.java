package zoopunk.backend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name="achievementsprogress")
public class AchievementProgress {
    @Column(name="userid")
    @Id
    private UUID userid;

    @Column(name="id")
    private UUID id;

    @Column(name="currentpoints")
    private int currentPoints;

}
