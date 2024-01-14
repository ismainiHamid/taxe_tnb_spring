package ma.land.services.implementations;

import ma.land.models.implementations.Client;
import ma.land.repositories.implementations.ClientRepository;
import ma.land.services.GenericService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientService extends GenericService<Client> {
    public ClientService(ClientRepository clientRepository) {
        super(clientRepository);
    }
}
