package ma.land.metier;

import ma.land.utils.T;

import java.util.List;

public interface IMetier<S extends T> {
    S save(S entity);

    S update(S entity);

    S delete(Long id);

    List<S> findAll();

    S findById(Long id);
}
