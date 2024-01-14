package ma.land.services.implementations;

import ma.land.models.implementations.Category;
import ma.land.repositories.implementations.CategoryRepository;
import ma.land.services.GenericService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryService extends GenericService<Category> {
    public CategoryService(CategoryRepository categoryRepository) {
        super(categoryRepository);
    }
}
