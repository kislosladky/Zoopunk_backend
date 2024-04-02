package zoopunk.backend.dto;

import java.util.UUID;

public class AchievementsDto {
    private UUID id;
    private String title;
    private String description;
    private int pointsfordone;
    private int currentpoints;

    public AchievementsDto(UUID id,
                           String title,
                           String description,
                           int pointsfordone,
                           int currentpoints)
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pointsfordone = pointsfordone;
        this.currentpoints = currentpoints;
    }

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

    public int getCurrentpoints() {
        return currentpoints;
    }

    public void setCurrentpoints(int currentpoints) {
        this.currentpoints = currentpoints;
    }
}
