package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Retrieve all products by category
    @Query("SELECT p FROM Product p WHERE p.category = ?1")
    List<Product> findByCategory(String category);

    // Update product price by ID
    @Modifying
    //@Transactional
    @Query("UPDATE Product p SET p.price = ?2 WHERE p.id = ?1")
    int updateProductPrice(Long id, Double price);

    // Delete product by ID
    @Modifying
   // @Transactional
    @Query("DELETE FROM Product p WHERE p.id = ?1")
    int deleteProductById(Long id);

    // Retrieve product by name
    @Query("SELECT p FROM Product p WHERE p.name = ?1")
    Optional<Product> findByName(String name);
}
