package zoopunk.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zoopunk.backend.Entity.Achievement;
import zoopunk.backend.EntityList.AchievementList;
import zoopunk.backend.Repository.AchievementRepository;

import java.util.List;

@Service
public class AchievementService {
    @Autowired
    private AchievementRepository achievementRepo;

    public List<Achievement> getAllAchievements() {
        return achievementRepo.findAll();
    }
}
