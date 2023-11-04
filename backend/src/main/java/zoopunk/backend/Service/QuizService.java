package zoopunk.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zoopunk.backend.Repository.QuizRepository;

import java.util.Collections;
import java.util.UUID;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    public void example() {
        quizRepository.findAllById(Collections.emptyList());
    }

    public String quizById(UUID uuid) {
        String result = quizRepository.findQuizById(uuid);
        return result;
    }

}
