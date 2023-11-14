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

    public Optional<Quiz> quizById(UUID uuid) {
        return quizRepository.findById(uuid);
    }


    public List<String> allQuizzes() {
        return quizRepository.findAllQuizzes();
    }
}

