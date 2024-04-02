package zoopunk.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import zoopunk.backend.Entity.Achievement;
import zoopunk.backend.Entity.AchievementProgress;
import zoopunk.backend.EntityList.AchievementList;
import zoopunk.backend.Repository.AchievementProgressRepository;
import zoopunk.backend.Service.AchievementService;
import zoopunk.backend.dto.AchievementsDto;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/achievement")
public class AchievementController {
    @Autowired
    AchievementService achievementService;

    @Autowired
    AchievementProgressRepository achievementProgressRepository;

    @GetMapping("/all")
    public ResponseEntity<AchievementList> getAllAchievementsForUser(@RequestParam UUID id) {
        List<AchievementsDto> dtoList = achievementService.getAllAchievements(id);

        if (!dtoList.isEmpty()) {
            AchievementList achievementList = new AchievementList(dtoList);

            return ResponseEntity.ok(achievementList);
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
