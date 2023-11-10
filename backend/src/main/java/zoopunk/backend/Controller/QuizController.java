package zoopunk.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        Optional<String> response = quizService.quizById(id);
        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    ///I'm not sure if we need it, actually
    @GetMapping("/example")
    public void example() {
        quizService.example();
    }

    @GetMapping("/all")
    public ResponseEntity<List<String>> getAllQuizzes() {
        List<String> response = quizService.allQuizzes();
        if (!response.isEmpty()) {
            return ResponseEntity.ok(response);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
