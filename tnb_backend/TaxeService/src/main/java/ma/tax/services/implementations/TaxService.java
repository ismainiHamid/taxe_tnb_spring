package ma.tax.services.implementations;

import jakarta.transaction.Transactional;
import ma.tax.models.implementations.Tax;
import ma.tax.repositories.implementations.TaxRepository;
import ma.tax.services.GenericService;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TaxService extends GenericService<Tax> {
    public TaxService(TaxRepository taxRepository){
        super(taxRepository);
    }
}
