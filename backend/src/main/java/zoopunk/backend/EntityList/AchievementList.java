package zoopunk.backend.EntityList;

import zoopunk.backend.dto.AchievementDto;

import java.util.List;

public class AchievementList {
    private List<AchievementDto> achievements;

    public AchievementList(List<AchievementDto> achievements) {
        this.achievements = achievements;
    }

    public List<AchievementDto> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<AchievementDto> achievements) {
        this.achievements = achievements;
    }
}
