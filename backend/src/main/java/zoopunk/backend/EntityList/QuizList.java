package zoopunk.backend.EntityList;

import java.util.List;

public class QuizList {
    private List<String> quizNames;

    public QuizList() {
        this.quizNames = null;
    }

    public List<String> getQuizNames() {
        return quizNames;
    }

    public void setQuizNames(List<String> quizNames) {
        this.quizNames = quizNames;
    }
}
