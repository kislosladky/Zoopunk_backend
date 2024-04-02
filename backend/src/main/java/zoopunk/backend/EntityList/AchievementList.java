package zoopunk.backend.EntityList;

import zoopunk.backend.Entity.Achievement;
import zoopunk.backend.dto.AchievementsDto;

import java.util.List;

public class AchievementList {
    private List<AchievementsDto> achievements;

    public AchievementList(List<AchievementsDto> achievements) {
        this.achievements = achievements;
    }

    public List<AchievementsDto> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<AchievementsDto> achievements) {
        this.achievements = achievements;
    }
}
