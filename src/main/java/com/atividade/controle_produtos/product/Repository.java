package com.atividade.controle_produtos.product;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface Repository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    boolean existsByName(@NotBlank String name);
}
