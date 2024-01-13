package ma.taxe.controllers.implementations;

import ma.taxe.controllers.GenericController;
import ma.taxe.models.implementations.Category;
import ma.taxe.services.implementations.CategoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
@CrossOrigin(value = "http://localhost:4200")
public class CategoryController extends GenericController<Category> {
    public CategoryController(CategoryService categoryService) {
        super(categoryService);
    }
}
