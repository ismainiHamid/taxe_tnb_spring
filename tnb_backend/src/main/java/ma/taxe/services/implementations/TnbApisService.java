package ma.taxe.services.implementations;

import lombok.AllArgsConstructor;
import ma.taxe.metier.ITnb;
import ma.taxe.models.implementations.Client;
import ma.taxe.models.implementations.TaxeTnb;
import ma.taxe.models.implementations.Terrain;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class TnbApisService implements ITnb {
    private TaxeTnbService taxeTnbService;

    @Override
    public Double calculerTaxeTnb(Client client, Integer year, Terrain terrain) {
        TaxeTnb taxeTnb = taxeTnbService.findAll().stream().filter(
                r -> Objects.equals(r.getClient(), client)
                        && Objects.equals(r.getTerrain(), terrain)
                        && Objects.equals(r.getTnbYear(), year)
        ).findFirst().orElse(null);
        assert taxeTnb != null;
        return taxeTnb.getTaux().getMontant() * taxeTnb.getTerrain().getSurface();
    }
}
