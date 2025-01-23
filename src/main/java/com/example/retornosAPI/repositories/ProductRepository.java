package com.example.retornosAPI.repositories;

import com.example.retornosAPI.models.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    // Método para buscar produtos pelo nome (case insensitive)
    List<ProductEntity> findByNameContainingIgnoreCase(String name);

    // Outros métodos personalizados que você pode precisar
    List<ProductEntity> findByCategory(String category);
}
