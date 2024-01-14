package ma.land.controllers.implementations;

import ma.land.controllers.GenericController;
import ma.land.models.implementations.Category;
import ma.land.services.implementations.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController extends GenericController<Category> {
    public CategoryController(CategoryService categoryService) {
        super(categoryService);
    }
}
