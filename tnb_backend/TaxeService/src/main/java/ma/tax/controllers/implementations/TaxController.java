package ma.tax.controllers.implementations;

import ma.tax.controllers.GenericController;
import ma.tax.models.implementations.Tax;
import ma.tax.services.implementations.TaxService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/taxes")
public class TaxController extends GenericController<Tax> {
    public TaxController(TaxService taxService) {
        super(taxService);
    }
}
