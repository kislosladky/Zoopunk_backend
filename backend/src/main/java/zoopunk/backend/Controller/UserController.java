package zoopunk.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import zoopunk.backend.EntityList.UserList;
import zoopunk.backend.Repository.UserRepository;
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
    @Autowired
    UserRepository userRepository;

    @GetMapping("/userById")
    public ResponseEntity<User> getUserById(@RequestParam UUID id) {
        Optional<User> response = userRepository.findById(id);
        return ResponseEntity.of(response);
    }

    @GetMapping("/ageBetween")
    public ResponseEntity<UserList> getUsersWithAgeBetween(@RequestParam Integer lowerAge, @RequestParam Integer upperAge) {
        List<User> response = userRepository.findByAgeBetween(lowerAge, upperAge);
        if (!response.isEmpty()) {
            UserList userList = new UserList();
            userList.setUserList(response);
            return ResponseEntity.ok(userList);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Void> postUser(@RequestBody User user, UriComponentsBuilder ucb) {
        User savedUser = userRepository.save(user);

        URI location = ucb.path("/user/userById?id={id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateUser(@RequestBody User updatedUser) {
        userRepository.save(updatedUser);

        return ResponseEntity.noContent().build();
    }

}
