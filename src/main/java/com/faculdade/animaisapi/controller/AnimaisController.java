package com.faculdade.animaisapi.controller;

import com.faculdade.animaisapi.model.Animais;
import com.faculdade.animaisapi.service.AnimaisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/animais")
public class AnimaisController {

    private AnimaisService animaisService;

    public AnimaisController(AnimaisService animalService) {
        this.animaisService = animaisService;
    }

    @PostMapping
    public Animais cadastrar(@Valid @RequestBody Animais animais) {
        return animaisService.cadastrar(animais);
    }
    @GetMapping
    public List<Animais> listarTodos() {
        return animaisService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animais> buscarPorId(@PathVariable UUID id) {
        return animaisService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Animais atualizar(
            @PathVariable UUID id,
            @Valid @RequestBody Animais animal) {

        return animaisService.atualizar(id, animal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable UUID id) {
        animaisService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}