package ma.auth.controllers.implementations;

import ma.auth.controllers.GenericController;
import ma.auth.models.implementations.Role;
import ma.auth.services.implementations.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/roles")
public class RoleController extends GenericController<Role> {
    public RoleController(RoleService roleService) {
        super(roleService);
    }
}
