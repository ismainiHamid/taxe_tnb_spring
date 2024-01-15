package ma.tnb.controllers;

import lombok.AllArgsConstructor;
import ma.tnb.respense.Land;
import ma.tnb.respense.Tax;
import ma.tnb.services.TnbService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "tnb")
@AllArgsConstructor
@CrossOrigin(value = "http://localhost:4200")
public class TnbController {
    private TnbService tnbService;

    @GetMapping(path = "/rate/{rate}/client/{client}/land/{land}")
    public Double calculateTnb(@PathVariable Integer rate, @PathVariable Long client, @PathVariable Long land) {
        return tnbService.calculateTnb(rate, client, land);
    }

    @GetMapping(path = "/findAllLandsByClient/{client}")
    public List<Land> findAllLandsByClient(@PathVariable Long client) {
        return tnbService.findAllLandsByClient(client);
    }

    @GetMapping(path = "/findAllTaxesByClient/{client}")
    public List<Tax> findAllTaxesByClient(@PathVariable Long client) {
        return tnbService.findAllTaxesByClient(client);
    }
}
