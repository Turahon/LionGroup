package org.example.liongroup.repo;

import org.example.liongroup.model.Address;
import org.example.liongroup.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
