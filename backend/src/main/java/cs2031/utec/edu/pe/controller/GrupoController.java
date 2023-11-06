package cs2031.utec.edu.pe.controller;

import cs2031.utec.edu.pe.model.Grupo;
import cs2031.utec.edu.pe.services.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos")
@CrossOrigin(origins = "*")
public class GrupoController {

    @Autowired
    private GrupoService service;

    @PostMapping
    public void create(@RequestBody Grupo grupo) {
        service.create(grupo);
    }

    @GetMapping
    public List<Grupo> read() {
        return service.read();
    }

    @GetMapping("/{id}")
    public Grupo read(@PathVariable Long id) {
        return service.read(id);
    }
    @PutMapping("/{id}")
    public void update(@RequestBody Grupo grupo, @PathVariable Long id) {
        service.update(id, grupo);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
