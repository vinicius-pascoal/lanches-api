package com.exemplo.lanchesapi.repository;

import com.exemplo.lanchesapi.model.Lanche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancheRepository extends JpaRepository<Lanche, Long> {
}
