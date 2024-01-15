package ma.tnb.metier;

import ma.tnb.respense.Land;
import ma.tnb.respense.Tax;

import java.util.List;

public interface IMetier {
    Double calculateTnb(Integer rate, Long client, Long land);

    List<Land> findAllLandsByClient(Long client);

    List<Tax> findAllTaxesByClient(Long client);
}
