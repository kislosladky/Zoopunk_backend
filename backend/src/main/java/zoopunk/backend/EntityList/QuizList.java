package zoopunk.backend.EntityList;

import zoopunk.backend.Entity.Quiz;
import zoopunk.backend.dto.QuizWithoutContent;

import java.util.List;

public class QuizList {
    private List<QuizWithoutContent> quizzes;

    public List<QuizWithoutContent> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<QuizWithoutContent> quizzes) {
        this.quizzes = quizzes;
    }

    public QuizList() {
        this.quizzes = null;
    }
}
