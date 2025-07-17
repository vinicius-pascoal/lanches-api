package com.exemplo.lanchesapi.controller;

import com.exemplo.lanchesapi.model.Lanche;
import com.exemplo.lanchesapi.service.LancheService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lanches")
public class LancheController {

    private final LancheService service;

    public LancheController(LancheService service) {
        this.service = service;
    }

    @GetMapping
    public List<Lanche> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lanche> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Lanche criar(@RequestBody Lanche lanche) {
        return service.salvar(lanche);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lanche> atualizar(@PathVariable Long id, @RequestBody Lanche lanche) {
        return service.buscarPorId(id).map(l -> {
            l.setNome(lanche.getNome());
            l.setDescricao(lanche.getDescricao());
            l.setPreco(lanche.getPreco());
            return ResponseEntity.ok(service.salvar(l));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return service.buscarPorId(id).map(l -> {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
