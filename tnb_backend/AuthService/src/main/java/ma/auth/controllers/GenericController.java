package ma.auth.controllers;

import lombok.AllArgsConstructor;
import ma.auth.services.GenericService;
import ma.auth.utils.T;
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
}
