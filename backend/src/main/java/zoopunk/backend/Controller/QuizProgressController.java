package zoopunk.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zoopunk.backend.Entity.QuizProgress;
import zoopunk.backend.Entity.User;
import zoopunk.backend.Service.QuizProgressService;
import zoopunk.backend.dto.QuizResult;

import java.util.UUID;

@Controller
@RequestMapping("/quizProgress")
public class QuizProgressController {
    @Autowired
    QuizProgressService quizProgressService;

    @PreAuthorize("hasRole('USER')")
    @PostMapping
    public ResponseEntity<QuizProgress> postQuizProgress(@RequestBody QuizResult quizResult) {
        UUID id = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        QuizProgress quizProgress = QuizProgress.builder()
                .userid(id)
                .quizResult(quizResult.getQuizResult())
                .quizid(quizResult.getQuizid()).build();
        
        quizProgressService.saveProgressAndGetAchievement(quizProgress);

        return ResponseEntity.noContent().build();
    }
}
