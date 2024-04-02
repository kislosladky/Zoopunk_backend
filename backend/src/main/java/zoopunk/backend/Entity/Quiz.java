package zoopunk.backend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.ColumnTransformer;

import java.util.UUID;

@Entity(name="quizzes")
public class Quiz {
    public Quiz() {}

    public Quiz(UUID id, UUID achievementsId, String name, String img, String description, String quizContent) {
        this.id = id;
        this.achievementsId = achievementsId;
        this.name = name;
        this.img = img;
        this.description = description;
        this.quizContent = quizContent;
    }


    @Column(name="id")
    @Id
    private UUID id;

    @Column(name="achievementsid")
    private UUID achievementsId;

    @Column(name="name")
    private String name;


    @Column(name="img")
    private String img;

    @Column(name="description")
    private String description;

    @Column(name="quizcontent", columnDefinition = "json")
    @ColumnTransformer(write = "?::jsonb")
    private String quizContent;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getQuizContent() {
        return quizContent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuizContent(String quizContent) {
        this.quizContent = quizContent;
    }

    public UUID getAchievementsId() {
        return achievementsId;
    }

    public void setAchievementsId(UUID achievementsId) {
        this.achievementsId = achievementsId;
    }
}
