package ma.auth.services.implementations;

import jakarta.transaction.Transactional;
import ma.auth.models.implementations.User;
import ma.auth.repositories.implementations.UserRepository;
import ma.auth.services.GenericService;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService extends GenericService<User> {
    public UserService(UserRepository userRepository) {
        super(userRepository);
    }

}
