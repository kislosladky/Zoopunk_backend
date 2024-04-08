package zoopunk.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zoopunk.backend.Entity.Achievement;
import zoopunk.backend.Entity.AchievementProgress;
import zoopunk.backend.Repository.AchievementProgressRepository;
import zoopunk.backend.Repository.AchievementRepository;
import zoopunk.backend.dto.AchievementDto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AchievementService {
    @Autowired
    private AchievementRepository achievementRepo;

    @Autowired
    private AchievementProgressRepository achievementProgressRepo;

    public List<AchievementDto> getAllAchievements(UUID userid) {
        List<AchievementProgress> progressList = achievementProgressRepo.findAllByUserid(userid);
        List<Achievement> achievementList = achievementRepo.findAll();

        List<AchievementDto> dtoList = new ArrayList<>();
        for (var achievement : achievementList) {
            int curpoints = progressList.stream()
                    .filter(progress -> progress.getId().equals(achievement.getId()))
                    .mapToInt(AchievementProgress::getCurrentPoints)
                    .findFirst()
                    .orElse(0);

            AchievementDto dto = AchievementDto.builder()
                    .id(achievement.getId())
                    .title(achievement.getTitle())
                    .description(achievement.getDescription())
                    .pointsfordone(achievement.getPointsfordone())
                    .currentpoints(curpoints)
                    .build();

            dtoList.add(dto);
        }

        return dtoList;
    }

    public AchievementProgress save(AchievementProgress result) {
        return achievementProgressRepo.save(result);
    }
}
