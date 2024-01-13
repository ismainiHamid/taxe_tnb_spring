package ma.taxe.services.implementations;

import ma.taxe.models.implementations.Land;
import ma.taxe.repositories.implementations.TerrainRepository;
import ma.taxe.services.GenericService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TerrainService extends GenericService<Land> {
    public TerrainService(TerrainRepository terrainRepository) {
        super(terrainRepository);
    }
}
