package org.example.liongroup.repo;

import org.example.liongroup.model.Address;
import org.example.liongroup.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepo extends JpaRepository<Photo, Long> {
}
