package zoopunk.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zoopunk.backend.Entity.QuizProgress;
import zoopunk.backend.Service.QuizProgressService;

import java.util.UUID;

@Controller
@RequestMapping("/quizProgress")
public class QuizProgressController {
    @Autowired
    QuizProgressService quizProgressService;

    @PostMapping
    public ResponseEntity<QuizProgress> postQuizProgress(@RequestBody QuizProgress quizProgress) {
        quizProgressService.saveProgressAndGetAchievement(quizProgress);

        return ResponseEntity.noContent().build();
    }
}
