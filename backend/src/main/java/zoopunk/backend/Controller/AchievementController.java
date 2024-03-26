package zoopunk.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import zoopunk.backend.Entity.Achievement;
import zoopunk.backend.Entity.AchievementProgress;
import zoopunk.backend.EntityList.AchievementList;
import zoopunk.backend.Repository.AchievementProgressRepository;
import zoopunk.backend.Service.AchievementService;

import java.util.List;

@Controller
@RequestMapping("/achievement")
public class AchievementController {
    @Autowired
    AchievementService achievementService;

    @Autowired
    AchievementProgressRepository achievementProgressRepository;

    @GetMapping("/all")
    public ResponseEntity<AchievementList> getAllAchievements() {
        List<Achievement> response = achievementService.getAllAchievements();

        if (!response.isEmpty()) {
            AchievementList achievements = new AchievementList();
            achievements.setAchievements(response);
            return ResponseEntity.ok(achievements);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveAchievement(@RequestBody AchievementProgress achievementResult) {
        achievementProgressRepository.save(achievementResult);

        return ResponseEntity.noContent().build();
    }
}
