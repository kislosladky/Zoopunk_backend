package zoopunk.backend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity(name="achievementsprogress")
public class AchievementProgress {
    @Column(name="userid")
    @Id
    private UUID userid;

    @Column(name="id")
    private UUID id;

    @Column(name="currentpoints")
    private int currentPoints;

    public AchievementProgress(UUID userid, UUID id) {
        this.userid = userid;
        this.id = id;
    }

    public AchievementProgress() {}

    public UUID getUserid() {
        return userid;
    }

    public void setUserid(UUID userid) {
        this.userid = userid;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }
}
