package zoopunk.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import zoopunk.backend.EntityList.UserList;
import zoopunk.backend.Service.UserService;
import zoopunk.backend.Entity.User;

import java.net.URI;
import java.util.List;
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

    @PutMapping("/update")
    public ResponseEntity<Void> updateUser(@RequestBody User updatedUser) {
        userService.save(updatedUser);

        return ResponseEntity.noContent().build();
    }

}
