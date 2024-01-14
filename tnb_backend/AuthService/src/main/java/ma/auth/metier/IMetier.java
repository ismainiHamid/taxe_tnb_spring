package ma.auth.metier;

import ma.auth.utils.T;

import java.util.List;

public interface IMetier<S extends T> {
    S save(S entity);

    S update(S entity);

    S delete(Long id);

    List<S> findAll();
}
