package ma.taxe.controllers.implementations;

import io.swagger.v3.oas.annotations.tags.Tag;
import ma.taxe.controllers.GenericController;
import ma.taxe.models.implementations.TaxeTnb;
import ma.taxe.services.GenericService;
import ma.taxe.services.implementations.TaxeTnbService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Taxe TNB")
@RestController
@RequestMapping(value = "/taxeTnb")
public class TaxeTnbController extends GenericController<TaxeTnb> {
    public TaxeTnbController(TaxeTnbService taxeTnbService) {
        super(taxeTnbService);
    }
}
