package zoopunk.backend.dto;

import lombok.Data;

@Data
public class UserUpdate {
    private String username;
    private String firstname;
    private String password;
}
