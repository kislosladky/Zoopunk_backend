package zoopunk.backend.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class AchievementDto {
    private UUID id;
    private String title;
    private String description;
    private int pointsfordone;
    private int currentpoints;
}
