package com.exemplo.lanchesapi.service;

import com.exemplo.lanchesapi.model.Lanche;
import com.exemplo.lanchesapi.repository.LancheRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LancheService {

    private final LancheRepository repository;

    public LancheService(LancheRepository repository) {
        this.repository = repository;
    }

    public List<Lanche> listarTodos() {
        return repository.findAll();
    }

    public Optional<Lanche> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Lanche salvar(Lanche lanche) {
        return repository.save(lanche);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}

