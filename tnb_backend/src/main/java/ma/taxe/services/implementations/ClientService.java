package ma.taxe.services.implementations;

import ma.taxe.models.implementations.Client;
import ma.taxe.repositories.implementations.ClientRepository;
import ma.taxe.services.GenericService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientService extends GenericService<Client> {
    public ClientService(ClientRepository clientRepository) {
        super(clientRepository);
    }
}
