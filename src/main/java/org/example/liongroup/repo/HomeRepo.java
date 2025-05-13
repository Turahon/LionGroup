package org.example.liongroup.repo;

import org.example.liongroup.model.Address;
import org.example.liongroup.model.Home;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepo extends JpaRepository<Home, Long> {
}
