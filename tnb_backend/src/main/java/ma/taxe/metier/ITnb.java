package ma.taxe.metier;

import ma.taxe.models.implementations.Client;
import ma.taxe.models.implementations.Terrain;

public interface ITnb {
    Double calculerTaxeTnb(Client client, Integer year, Terrain terrain);
}
