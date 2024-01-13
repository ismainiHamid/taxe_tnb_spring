package ma.taxe.controllers.implementations;

import io.swagger.v3.oas.annotations.tags.Tag;
import ma.taxe.controllers.GenericController;
import ma.taxe.models.implementations.Taux;
import ma.taxe.services.implementations.TauxService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Taxe")
@RestController
@RequestMapping(value = "/taxes")
public class TauxController extends GenericController<Taux> {
    public TauxController(TauxService tauxService) {
        super(tauxService);
    }
}
