package zoopunk.backend.dto;

import java.util.UUID;

public class QuizWithoutContent {
    private UUID id;
    private String name;
    private String description;
    private String img;

    public QuizWithoutContent(UUID id,
                              String name,
                              String description,
                              String img) {
        this.id = id;
        this.description = description;
        this.img = img;
        this.name = name;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
