package ma.taxe.metier;

import ma.taxe.utils.T;

import java.util.List;

public interface IMetier<S extends T> {
    S save(S Object);

    S update(S Object);

    S delete(Long id);

    List<S> findAll();

    S findById(Long id);
}
