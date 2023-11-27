package zoopunk.backend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity(name="achievements")
public class Achievement {

    public Achievement() {}

    @Column(name="id")
    @Id
    private UUID id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="pointsfordone")
    private int pointsfordone;

    @Column(name="done")
    private int done;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPointsfordone() {
        return pointsfordone;
    }

    public void setPointsfordone(int pointsfordone) {
        this.pointsfordone = pointsfordone;
    }

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }
}
