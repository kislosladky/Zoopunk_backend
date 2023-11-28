package zoopunk.backend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.util.UUID;

@Entity(name="achievementsProgress")
public class AchievementProgress {
    @Column(name="userid")
    private UUID userid;

    @Column(name="id")
    private UUID id;

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
}
