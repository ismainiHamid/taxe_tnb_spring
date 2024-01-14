package ma.tax.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.tax.metier.IMetier;
import ma.tax.repositories.GenericRepository;
import ma.tax.utils.T;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Transactional
@AllArgsConstructor
public class GenericService<S extends T> implements IMetier<S> {
    private GenericRepository<S> genericRepository;

    @Override
    public S save(S entity) {
        return (Objects.nonNull(entity) ? this.genericRepository.save(entity) : null);
    }

    @Override
    public S update(S entity) {
        S result = null;
        if (Objects.nonNull(entity)) {
            result = this.genericRepository.findById(entity.getId()).orElse(null);
            if (Objects.nonNull(result)) {
                result.setUpdatedAt(new Date());
                this.save(result);
            }
        }
        return result;
    }

    @Override
    public S delete(Long id) {
        S result = null;
        result = this.genericRepository.findById(id).orElse(null);
        if (Objects.nonNull(result)) {
            result.setDeletedAt(new Date());
        }
        return result;
    }

    @Override
    public List<S> findAll() {
        return genericRepository.findAll().stream().filter(s -> Objects.isNull(s.getDeletedAt())).toList();
    }
}
