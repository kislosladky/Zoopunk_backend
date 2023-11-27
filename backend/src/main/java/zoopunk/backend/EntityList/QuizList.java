package zoopunk.backend.EntityList;

import zoopunk.backend.Entity.Quiz;

import java.util.List;

public class QuizList {
    private List<String> quizNames;
    private List<Quiz> quizzes;

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public QuizList() {
        this.quizNames = null;
        this.quizzes = null;
    }

    public List<String> getQuizNames() {
        return quizNames;
    }

    public void setQuizNames(List<String> quizNames) {
        this.quizNames = quizNames;
    }
}
