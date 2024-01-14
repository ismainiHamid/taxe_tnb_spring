package ma.tax.services.implementations;

import jakarta.transaction.Transactional;
import ma.tax.models.implementations.Rate;
import ma.tax.repositories.implementations.RateRepository;
import ma.tax.services.GenericService;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RateService extends GenericService<Rate> {
    public RateService(RateRepository rateRepository) {
        super(rateRepository);
    }
}
