package zoopunk.backend.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import zoopunk.backend.Entity.Role;
import zoopunk.backend.Entity.User;
import zoopunk.backend.Repository.UserRepository;
import zoopunk.backend.dto.UserUpdate;
import zoopunk.backend.exception.BadSignupException;
import zoopunk.backend.exception.BadUserUpdateException;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private  PasswordEncoder passwordEncoder;

    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
    }

    /**
     * Сохранение пользователя
     *
     * @return сохраненный пользователь
     */
    public User save(User user) {
        return userRepository.save(user);
    }


    /**
     * Создание пользователя
     *
     * @return созданный пользователь
     */
    public User create(User user) throws BadSignupException {
        if (userRepository.existsByUsername(user.getUsername())) {
            // Заменить на свои исключения
            throw new BadSignupException("Пользователь с таким логином уже существует");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new BadSignupException("Пользователь с такой почтой уже существует");
        }

        return save(user);
    }

    /**
     * Получение пользователя по имени пользователя
     *
     * @return пользователь
     */
    public User getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));

    }

    /**
     * Получение пользователя по имени пользователя
     * <p>
     * Нужен для Spring Security
     *
     * @return пользователь
     */
    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    /**
     * Получение текущего пользователя
     *
     * @return текущий пользователь
     */
    public User getCurrentUser() {
        // Получение имени пользователя из контекста Spring Security
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }


    public void updateUser(UserUpdate userUpdate) throws BadUserUpdateException {
        User user = getCurrentUser();
        if (userUpdate.getFirstname() != null ) {
            if (userUpdate.getFirstname().length() > 255) {
                throw new BadUserUpdateException("Имя не должно быть длиннее 255 символов");
            }
            user.setFirstname(userUpdate.getFirstname());
        }

        if (userUpdate.getUsername() != null) {
            if (userUpdate.getUsername().length() > 50 || userUpdate.getUsername().length() < 2) {
                throw new BadUserUpdateException("Длина логина должна быть от 2 до 50 символов");
            }

            if (userRepository.existsByUsername(userUpdate.getUsername())) {
                throw new BadUserUpdateException("Пользователь с таким логином уже существует");
            }
            user.setUsername(userUpdate.getUsername());
        }
        if (userUpdate.getPassword() != null) {
            if (userUpdate.getPassword().length() < 8 || userUpdate.getPassword().length() > 255) {
                throw new BadUserUpdateException("Длина пароля должна быть от 8 до 255 символов");
            }
            user.setPassword(passwordEncoder.encode(userUpdate.getPassword()));
        }
        save(user);
    }


    /**
     * Выдача прав администратора текущему пользователю
     * <p>
     * Нужен для демонстрации
     */
    @Deprecated
    public void getAdmin() {
        var user = getCurrentUser();
        user.setRole(Role.ROLE_ADMIN);
        save(user);
    }
}
