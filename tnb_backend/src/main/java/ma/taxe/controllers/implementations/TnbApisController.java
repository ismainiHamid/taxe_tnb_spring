package ma.taxe.controllers.implementations;

import lombok.AllArgsConstructor;
import ma.taxe.models.implementations.Client;
import ma.taxe.models.implementations.Terrain;
import ma.taxe.services.implementations.TnbApisService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tnbApis")
@AllArgsConstructor
@CrossOrigin(value = "http://localhost:4200")
public class TnbApisController {
    private TnbApisService tnbApisService;

    @PostMapping(value = "/calculate")
    public Double calculerTaxeTnb(@RequestBody Client client, @RequestParam Integer year, @RequestBody Terrain terrain) {
        return tnbApisService.calculerTaxeTnb(client, year, terrain);
    }
}
