package ma.taxe.services.implementations;

import lombok.AllArgsConstructor;
import ma.taxe.metier.ITnb;
import ma.taxe.models.implementations.Taux;
import ma.taxe.models.implementations.Land;
import ma.taxe.models.implementations.request.Tnb;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class TnbApisService implements ITnb {
    private  TauxService tauxService;
    private TerrainService terrainService;
    private ClientService clientService;

    @Override
    public Double calculerTaxeTnb(Tnb tnb) {
        Land land = terrainService.findById(tnb.getLand().getId());
        Taux taux = tauxService.findAll().stream().filter(t -> t.getCategory().equals(land.getCategory())).findFirst().orElse(null);
        return taux.getMontant() * land.getSurface();
    }
}
