package ma.taxe.controllers.implementations;

import ma.taxe.controllers.GenericController;
import ma.taxe.models.implementations.Client;
import ma.taxe.services.implementations.ClientService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
@CrossOrigin(value = "http://localhost:4200")
public class ClientController extends GenericController<Client> {
    public ClientController(ClientService clientService) {
        super(clientService);
    }
}
