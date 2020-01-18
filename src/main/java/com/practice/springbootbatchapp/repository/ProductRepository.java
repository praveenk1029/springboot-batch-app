package com.practice.springbootbatchapp.repository;

import com.practice.springbootbatchapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
