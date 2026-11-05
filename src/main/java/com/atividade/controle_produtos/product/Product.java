package com.atividade.controle_produtos.product;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id")
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private Integer qtt_in_stock;

    private Boolean active;

    private LocalDateTime createdAt;

    private  LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Product (RequestProduct data){
        this.name = data.name();
        this.description = data.description();
        this.price = data.price();
        this.qtt_in_stock = data.qtt_in_stock();
        this.active = true;
    }
}
