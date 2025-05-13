package org.example.liongroup.repo;

import org.example.liongroup.model.Address;
import org.example.liongroup.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepo extends JpaRepository<Job, Long> {
}
