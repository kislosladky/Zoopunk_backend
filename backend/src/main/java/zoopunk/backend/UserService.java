package zoopunk.backend;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class UserService {
    private UserRepository userRepo;

    @Transactional
    public void execute() {
        userRepo.findAllById(Collections.emptyList());
        userRepo.customSelect(Collections.emptyList());
    }
}
