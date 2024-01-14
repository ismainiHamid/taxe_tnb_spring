package ma.auth.services.implementations;

import jakarta.transaction.Transactional;
import ma.auth.models.implementations.Role;
import ma.auth.repositories.implementations.RoleRepository;
import ma.auth.services.GenericService;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleService extends GenericService<Role> {
    public RoleService(RoleRepository roleRepository) {
        super(roleRepository);
    }
}
