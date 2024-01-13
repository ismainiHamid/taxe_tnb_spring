package ma.taxe.controllers.implementations;

import ma.taxe.controllers.GenericController;
import ma.taxe.models.implementations.TaxeTnb;
import ma.taxe.services.implementations.TaxeTnbService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/taxeTnb")
@CrossOrigin(value = "http://localhost:4200")
public class TaxeTnbController extends GenericController<TaxeTnb> {
    public TaxeTnbController(TaxeTnbService taxeTnbService) {
        super(taxeTnbService);
    }
}
