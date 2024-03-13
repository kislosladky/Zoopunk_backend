package zoopunk.backend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity(name="quizprogress")
public class QuizProgress {
    public QuizProgress() {}

    public QuizProgress(UUID userid,
                        UUID quizid,
                        int quizResult)
    {
        this.userid = userid;
        this.quizid = quizid;
        this.quizResult = quizResult;
    }

    @Column(name="userid")
    @Id
    private UUID userid;

    @Column(name="quizid")
    private UUID quizid;

    @Column(name="quizresult")
    private int quizResult;

    public UUID getUserid() {
        return userid;
    }

    public void setUserid(UUID userid) {
        this.userid = userid;
    }

    public UUID getQuizid() {
        return quizid;
    }

    public void setQuizid(UUID quizid) {
        this.quizid = quizid;
    }

    public int getQuizResult() {
        return quizResult;
    }

    public void setQuizResult(int quizResult) {
        this.quizResult = quizResult;
    }
}
