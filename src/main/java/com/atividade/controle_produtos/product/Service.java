package com.atividade.controle_produtos.product;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    Repository repository;

    public List<Product> search(Filter filter) {
        Specification<Product> spec = Specification.allOf();

        if (filter.id() != null) {
            spec = spec.and(
                    (root, query, cb) ->
                            cb.equal(root.get("id"), filter.id()));
        }
        if (filter.name() != null && !filter.name().isBlank()) {
            spec = spec.and(
                    (root, query, cb) ->
                            cb.like(
                                    cb.lower(root.get("name")), "%" + filter.name().toLowerCase() + "%"));
        }
        if (filter.active() != null) {
            spec = spec.and(
                    (root, query, cb) ->
                            cb.equal(root.get("active"), filter.active()));
        }
        return repository.findAll(spec);
    }

    @Transactional
    public Product register(RequestProduct data) {
        if (repository.existsByName(data.name())) {
            throw new IllegalArgumentException("Produto já cadastrado.");
        }
        Product product = new Product(data);
        return repository.save(product);
    }

    @Transactional
    public Product update(Long id, PatchProduct data) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado."));

        if (data.name() != null) {
            product.setName(data.name());
        }
        if (data.description() != null) {
            product.setDescription(data.description());
        }
        if (data.price() != null) {
            product.setPrice(data.price());
        }
        if (data.qtt_in_stock() != null) {
            product.setQtt_in_stock(data.qtt_in_stock());
        }
        if (data.active() != null) {
            product.setActive(data.active());
        }
        return repository.save(product);
    }

    public void delete(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado."));
        repository.delete(product);
    }
}
