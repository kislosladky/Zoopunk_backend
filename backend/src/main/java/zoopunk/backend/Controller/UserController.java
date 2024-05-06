package zoopunk.backend.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import zoopunk.backend.dto.UpdateStatus;
import zoopunk.backend.Service.UserService;
import zoopunk.backend.Entity.User;
import zoopunk.backend.dto.UserUpdate;
import zoopunk.backend.exception.BadUserUpdateException;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/userById")
    public ResponseEntity<User> getUserById() {
        UUID id = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        Optional<User> response = userService.findById(id);
        return ResponseEntity.of(response);
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping
    public ResponseEntity<Void> postUser(@RequestBody User user, UriComponentsBuilder ucb) {
        User newUser = new User(null,
                user.getPassword(),
                user.getEmail(),
                user.getRole(),
                user.getFirstname(),
                user.getUsername(),
                user.getImage());

        User savedUser = userService.save(newUser);

        URI location = ucb.path("/user/userById?id={id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PreAuthorize("hasRole('USER')")
    @PatchMapping("/update")
    public ResponseEntity<UpdateStatus> updateUser(@RequestBody UserUpdate userUpdate) {
        UpdateStatus updateStatus;
        try {
            userService.updateUser(userUpdate);
        } catch (BadUserUpdateException exception) {
            updateStatus = UpdateStatus.builder()
                    .status("Error")
                    .message(exception.getMessage())
                    .build();
            return ResponseEntity.ok(updateStatus);
        }

        updateStatus = UpdateStatus.builder()
                .status("Ok")
                .message("Ok")
                .build();

        return ResponseEntity.ok(updateStatus);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<UpdateStatus> handleAccessDeniedException(Exception ex, HttpServletRequest request){
        var updateStatus = UpdateStatus.builder()
                .status("Error")
                .message("Для данного действия необходимо войти в приложение").build();
        return ResponseEntity.ok(updateStatus);
    }
}
