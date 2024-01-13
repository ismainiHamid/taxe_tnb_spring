package ma.taxe.metier;

import ma.taxe.models.implementations.request.Tnb;

public interface ITnb {
    Double calculerTaxeTnb(Tnb tnb);
}
