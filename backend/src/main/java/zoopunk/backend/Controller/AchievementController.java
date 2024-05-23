package zoopunk.backend.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import zoopunk.backend.Entity.AchievementProgress;
import zoopunk.backend.Entity.User;
import zoopunk.backend.EntityList.AchievementList;
import zoopunk.backend.Service.AchievementService;
import zoopunk.backend.dto.AchievementDto;
import zoopunk.backend.dto.UpdateStatus;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/achievement")
public class AchievementController {
    @Autowired
    AchievementService achievementService;

    @GetMapping("/all")
    public ResponseEntity<AchievementList> getAllAchievementsForUser() {
        UUID userid = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        List<AchievementDto> dtoList = achievementService.getAllAchievements(userid);

        if (!dtoList.isEmpty()) {
            AchievementList achievementList = new AchievementList(dtoList);

            return ResponseEntity.ok(achievementList);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/save")
    public ResponseEntity<Void> saveAchievement(@RequestBody AchievementProgress achievementResult) {
        achievementService.save(achievementResult);

        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<UpdateStatus> handleAccessDeniedException(Exception ex, HttpServletRequest request){
        var updateStatus = UpdateStatus.builder()
                .status("Error")
                .message("Для данного действия необходимо войти в приложение").build();
        return ResponseEntity.ok(updateStatus);
    }
}
