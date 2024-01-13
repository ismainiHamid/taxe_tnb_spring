package ma.taxe.controllers;

import lombok.AllArgsConstructor;
import ma.taxe.services.GenericService;
import ma.taxe.utils.T;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
public class GenericController<S extends T> {
    private GenericService<S> genericService;

    @PostMapping
    public S save(@RequestBody S Object) {
        return genericService.save(Object);
    }

    @PutMapping
    public S update(@RequestBody S Object) {
        return genericService.update(Object);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        genericService.delete(id);
    }

    @GetMapping
    public List<S> findAll() {
        return genericService.findAll();
    }

    @GetMapping(value = "/{id}")
    public S findById(@PathVariable Long id) {
        return genericService.findById(id);
    }
}
