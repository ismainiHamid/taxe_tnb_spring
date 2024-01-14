package ma.land.controllers.implementations;

import ma.land.controllers.GenericController;
import ma.land.models.implementations.Client;
import ma.land.services.implementations.ClientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientController extends GenericController<Client> {
    public ClientController(ClientService clientService) {
        super(clientService);
    }
}
