package zoopunk.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zoopunk.backend.Entity.Quiz;
import zoopunk.backend.Repository.QuizRepository;

import java.util.*;

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

    public List<String> allQuizzes() {
        List<Quiz> quizzes = quizRepository.findAll();
        List<String> quizNames = new ArrayList<>();
        for (Quiz quiz : quizzes) {
            quizNames.add(quiz.getQuizContent());
        }
        return quizNames;
    }
}
