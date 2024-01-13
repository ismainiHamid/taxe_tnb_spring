package ma.taxe.services;

import lombok.AllArgsConstructor;
import ma.taxe.metier.IMetier;
import ma.taxe.repositories.GenericRepository;
import ma.taxe.utils.T;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Transactional
@AllArgsConstructor
public class GenericService<S extends T> implements IMetier<S> {
    private GenericRepository<S> genericRepository;

    @Override
    public S save(S Object) {
        return (!Objects.isNull(Object)) ? genericRepository.save(Object) : null;
    }

    @Override
    public S update(S Object) {
        if (!Objects.isNull(Object)) {
            S result = genericRepository.save(Object);
            result.setUpdatedAt(new Date());
            return result;
        }
        return null;
    }

    @Override
    public S delete(Long id) {
        S result = this.findById(id);
        assert result != null;
        result.setDeletedAt(new Date());
        return result;
    }

    @Override
    public List<S> findAll() {
        return genericRepository.findAll().stream().filter(s -> Objects.isNull(s.getDeletedAt())).toList();
    }

    @Override
    public S findById(Long id) {
        return genericRepository.findById(id).stream().filter(s -> Objects.isNull(s.getDeletedAt())).findFirst().orElse(null);
    }
}
