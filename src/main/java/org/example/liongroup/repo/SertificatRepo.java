package org.example.liongroup.repo;

import org.example.liongroup.model.Address;
import org.example.liongroup.model.Sertificat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SertificatRepo extends JpaRepository<Sertificat, Long> {
}
