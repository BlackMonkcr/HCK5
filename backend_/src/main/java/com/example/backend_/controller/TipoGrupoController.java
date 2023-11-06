package com.example.backend_.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import com.example.backend_.services.TipoGrupoService;
import com.example.backend_.model.TipoGrupo;
import com.example.backend_.model.Grupo;




@Controller
@RequestMapping("/tipos")
@CrossOrigin(origins = "*")
public class TipoGrupoController {
    private final TipoGrupoService tipoGrupoService;

    @Autowired
    public TipoGrupoController(TipoGrupoService tipoGrupoService) {
        Assert.notNull(tipoGrupoService, "tipoGrupoService must not be null!");
        this.tipoGrupoService = tipoGrupoService;
    }

    @GetMapping
    public ResponseEntity<List<TipoGrupo>> getAlltipoGrupo() {
        List<TipoGrupo> tipoGrupo = tipoGrupoService.getAllTipos();
        return ResponseEntity.ok(tipoGrupo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoGrupo> getTipoGrupoById(@PathVariable Long id) {
        TipoGrupo tipoGrupo = tipoGrupoService.getTipoById(id);
        if (tipoGrupo != null) {
            return ResponseEntity.ok(tipoGrupo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/group/{id}") //ns donde deberia estar
    public ResponseEntity<List<Grupo>> getGroupByTipoGrupoId(@PathVariable Long id) {
        List<Grupo> groups = tipoGrupoService.getTipoGrupo(id);
        return ResponseEntity.ok(groups);
    }
    

    @PostMapping
    public ResponseEntity<TipoGrupo> createTipoGrupo(@RequestBody TipoGrupo tipoGrupo) {
        TipoGrupo createdTipoGroup = tipoGrupoService.createTipoGrupo(tipoGrupo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTipoGroup);
    }

    @PostMapping("/{id}/add-group/{groupId}")
    public ResponseEntity<TipoGrupo> addGroupToTipo(@PathVariable Long id, @PathVariable Long groupId) {
        TipoGrupo tipoGrupo = tipoGrupoService.addGroupToTipo(id, groupId);
        if (tipoGrupo != null) {
            return ResponseEntity.ok(tipoGrupo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}





