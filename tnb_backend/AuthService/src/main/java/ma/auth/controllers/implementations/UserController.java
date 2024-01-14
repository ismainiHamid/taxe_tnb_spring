package ma.auth.controllers.implementations;

import ma.auth.controllers.GenericController;
import ma.auth.models.implementations.User;
import ma.auth.services.implementations.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserController extends GenericController<User> {
    public UserController(UserService userService) {
        super(userService);
    }
}
