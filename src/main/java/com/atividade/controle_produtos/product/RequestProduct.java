package com.atividade.controle_produtos.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record RequestProduct(
        @NotBlank
        String name,

        String description,

        @NotNull
        BigDecimal price,

        @NotNull
        Integer qtt_in_stock
) {
}
