package zoopunk.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zoopunk.backend.Entity.User;
import zoopunk.backend.Repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    @Transactional
    public void execute() {
        userRepo.findAllById(Collections.emptyList());
        userRepo.customSelect(Collections.emptyList());
    }

    public Optional<User> findById(UUID id) {
        return userRepo.findById(id);
    }

    public List<User> findByAgeBetween(Integer lowerBound, Integer upperBound) {
        return userRepo.findByAgeBetween(lowerBound,upperBound);
    }
}
