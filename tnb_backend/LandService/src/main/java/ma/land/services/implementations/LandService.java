package ma.land.services.implementations;

import ma.land.models.implementations.Land;
import ma.land.repositories.implementations.LandRepository;
import ma.land.services.GenericService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LandService extends GenericService<Land> {
    public LandService(LandRepository landRepository) {
        super(landRepository);
    }
}
