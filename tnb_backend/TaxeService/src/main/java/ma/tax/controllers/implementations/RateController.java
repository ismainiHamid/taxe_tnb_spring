package ma.tax.controllers.implementations;

import ma.tax.controllers.GenericController;
import ma.tax.models.implementations.Rate;
import ma.tax.services.implementations.RateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "rates")
public class RateController extends GenericController<Rate> {
    public RateController(RateService rateService) {
        super(rateService);
    }
}
