package ma.taxe.services.implementations;

import ma.taxe.models.GenericModel;
import ma.taxe.models.implementations.TaxeTnb;
import ma.taxe.repositories.implementations.TaxeTnbRepository;
import ma.taxe.services.GenericService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TaxeTnbService extends GenericService<TaxeTnb> {
    public TaxeTnbService(TaxeTnbRepository taxeTnbRepository){ super(taxeTnbRepository); }
}
