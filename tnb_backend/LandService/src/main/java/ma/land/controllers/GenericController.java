package ma.land.controllers;

import lombok.AllArgsConstructor;
import ma.land.services.GenericService;
import ma.land.utils.T;
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
    public void delete(@PathVariable Long id) {
        genericService.delete(id);
    }

    @GetMapping
    public List<S> findAll() {
        return genericService.findAll();
    }
}
