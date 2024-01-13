package ma.taxe.controllers.implementations;

import ma.taxe.controllers.GenericController;
import ma.taxe.models.implementations.Terrain;
import ma.taxe.services.implementations.TerrainService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/terrains")
@CrossOrigin(value = "http://localhost:4200")
public class TerrainController extends GenericController<Terrain> {
    public TerrainController(TerrainService terrainService) {
        super(terrainService);
    }
}
