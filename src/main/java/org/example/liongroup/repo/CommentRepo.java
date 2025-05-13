package org.example.liongroup.repo;

import org.example.liongroup.model.Address;
import org.example.liongroup.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
