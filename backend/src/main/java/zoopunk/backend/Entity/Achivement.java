package zoopunk.backend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.UUID;

@Entity
public class Achivement {
    private UUID userId;
    private String title;
    private int progress;
    private boolean done;
}
