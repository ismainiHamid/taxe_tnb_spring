package ma.tax.controllers;

import lombok.AllArgsConstructor;
import ma.tax.services.GenericService;
import ma.tax.utils.T;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@CrossOrigin(value = "http://localhost:4200")
public class GenericController<S extends T> {
    private GenericService<S> genericService;

    @PostMapping
    public S save(@RequestBody S entity) {
        return genericService.save(entity);
    }

    @PutMapping
    public S update(@RequestBody S entity) {
        return genericService.update(entity);
    }

    @DeleteMapping(path = "/{id}")
    public S delete(@PathVariable Long id) {
        return genericService.delete(id);
    }

    @GetMapping
    public List<S> findAll() {
        return genericService.findAll();
    }

    @GetMapping(path = "/{id}")
    public S findById(@PathVariable Long id) {
        return genericService.findById(id);
    }
}
