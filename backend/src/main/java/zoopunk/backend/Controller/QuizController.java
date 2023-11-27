package zoopunk.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zoopunk.backend.Entity.Quiz;
import zoopunk.backend.EntityList.QuizList;
import zoopunk.backend.Service.QuizService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @GetMapping("/byId")
    public ResponseEntity<String> getQuizById(@RequestParam UUID id) {
        Optional<Quiz> response = quizService.quizById(id);

        if (response.isPresent()) {
            //Here I would also want to use ResponseEntity.of,
            //but we need to send only one field of entity
            return ResponseEntity.ok(response.get().getQuizContent());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<QuizList> getAllQuizzes() {
        List<Quiz> response = quizService.allQuizzes();

        if (!response.isEmpty()) {
            QuizList quizList = new QuizList();
            quizList.setQuizzes(response);
            return ResponseEntity.ok(quizList);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
