package zoopunk.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zoopunk.backend.Entity.Achievement;
import zoopunk.backend.Entity.AchievementProgress;
import zoopunk.backend.EntityList.AchievementList;
import zoopunk.backend.Repository.AchievementProgressRepository;
import zoopunk.backend.Repository.AchievementRepository;
import zoopunk.backend.dto.AchievementsDto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AchievementService {
    @Autowired
    private AchievementRepository achievementRepo;

    @Autowired
    private AchievementProgressRepository achievementProgressRepo;

    public List<AchievementsDto> getAllAchievements(UUID userid) {
        List<AchievementProgress> progressList = achievementProgressRepo.findAllByUserid(userid);
        List<Achievement> achievementList = achievementRepo.findAll();

        List<AchievementsDto> DtoList = new ArrayList<>();
        for (var achievement : achievementList) {
            int curpoints = progressList.stream()
                    .filter(progress -> progress.getId().equals(achievement.getId()))
                    .mapToInt(AchievementProgress::getCurrentPoints)
                    .findFirst()
                    .orElse(0);

            AchievementsDto dto = new AchievementsDto(achievement.getId(),
                                                      achievement.getTitle(),
                                                      achievement.getDescription(),
                                                      achievement.getPointsfordone(),
                                                      curpoints);
            DtoList.add(dto);
        }

        return DtoList;
    }
}
