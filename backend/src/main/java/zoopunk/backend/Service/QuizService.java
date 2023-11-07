package zoopunk.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zoopunk.backend.Repository.QuizRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    public void example() {
        quizRepository.findAllById(Collections.emptyList());
    }

    public Optional<String> quizById(UUID uuid) {
        return quizRepository.findQuizById(uuid);
    }

    public List<String> allQuizes() {
        return quizRepository.findAllQuiz();
    }
}
