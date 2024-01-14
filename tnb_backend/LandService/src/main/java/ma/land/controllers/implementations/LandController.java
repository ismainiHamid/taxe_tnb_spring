package ma.land.controllers.implementations;

import ma.land.controllers.GenericController;
import ma.land.models.implementations.Land;
import ma.land.services.implementations.LandService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/lands")
public class LandController extends GenericController<Land> {
    public LandController(LandService landService) {
        super(landService);
    }
}
