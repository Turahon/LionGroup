package org.example.liongroup.repo;

import org.example.liongroup.model.Address;
import org.example.liongroup.model.Icon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IconRepo extends JpaRepository<Icon, Long> {
}
