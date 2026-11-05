package com.atividade.controle_produtos.product;

import java.math.BigDecimal;

public record PatchProduct(

        String name,

        String description,

        BigDecimal price,

        Integer qtt_in_stock,

        Boolean active
) {
}
