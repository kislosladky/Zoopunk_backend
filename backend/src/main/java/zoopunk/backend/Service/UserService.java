package zoopunk.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zoopunk.backend.Repository.UserRepository;

import java.util.Collections;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    @Transactional
    public void execute() {
        userRepo.findAllById(Collections.emptyList());
        userRepo.customSelect(Collections.emptyList());
    }
}
