package zoopunk.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zoopunk.backend.EntityList.UserList;
import zoopunk.backend.Service.UserService;
import zoopunk.backend.Entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/userById")
    public ResponseEntity<User> getUserById(@RequestParam UUID id) {
        Optional<User> response = userService.findById(id);
        return ResponseEntity.of(response);
    }

    @GetMapping("/ageBetween")
    public ResponseEntity<UserList> getUsersWithAgeBetween(@RequestParam Integer lowerAge, @RequestParam Integer upperAge) {
        List<User> response = userService.findByAgeBetween(lowerAge, upperAge);
        if (!response.isEmpty()) {
            UserList userList = new UserList();
            userList.setUserList(response);
            return ResponseEntity.ok(userList);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
