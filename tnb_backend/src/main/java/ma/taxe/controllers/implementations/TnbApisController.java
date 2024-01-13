package ma.taxe.controllers.implementations;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import ma.taxe.models.implementations.Client;
import ma.taxe.models.implementations.Terrain;
import ma.taxe.services.implementations.TnbApisService;
import org.springframework.web.bind.annotation.*;

@Tag(name = "TNB Apis")
@RestController
@RequestMapping(value = "/tnbApis")
@AllArgsConstructor
public class TnbApisController {
    private TnbApisService tnbApisService;

    @GetMapping(value = "/calculerTnb")
    public Double calculerTaxeTnb(@RequestBody Client client, @RequestParam Integer year, @RequestBody Terrain terrain) {
        return tnbApisService.calculerTaxeTnb(client, year, terrain);
    }
}
