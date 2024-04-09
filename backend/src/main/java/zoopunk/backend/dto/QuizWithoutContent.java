package zoopunk.backend.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class QuizWithoutContent {
    private UUID id;
    private String name;
    private String description;
    private String img;
}
