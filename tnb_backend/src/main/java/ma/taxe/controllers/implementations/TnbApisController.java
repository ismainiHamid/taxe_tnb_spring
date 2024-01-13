package ma.taxe.controllers.implementations;

import lombok.AllArgsConstructor;
import ma.taxe.models.implementations.request.Tnb;
import ma.taxe.services.implementations.TnbApisService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tnbApis")
@AllArgsConstructor
@CrossOrigin(value = "http://localhost:4200")
public class TnbApisController {
    private TnbApisService tnbApisService;

    @PostMapping(value = "/calculate")
    public Double calculerTaxeTnb(@RequestBody Tnb tnb) {
        return tnbApisService.calculerTaxeTnb(tnb);
    }
}
