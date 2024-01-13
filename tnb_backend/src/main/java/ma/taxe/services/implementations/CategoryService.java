package ma.taxe.services.implementations;

import ma.taxe.models.implementations.Category;
import ma.taxe.repositories.implementations.CategoryRepository;
import ma.taxe.services.GenericService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryService extends GenericService<Category> {
    public CategoryService(CategoryRepository categoryRepository) {
        super(categoryRepository);
    }
}
