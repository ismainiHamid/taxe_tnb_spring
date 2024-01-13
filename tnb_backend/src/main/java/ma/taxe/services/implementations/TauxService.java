package ma.taxe.services.implementations;

import ma.taxe.models.implementations.Taux;
import ma.taxe.repositories.implementations.TauxRepository;
import ma.taxe.services.GenericService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TauxService extends GenericService<Taux> {
    public TauxService(TauxRepository tauxRepository) {
        super(tauxRepository);
    }
}
