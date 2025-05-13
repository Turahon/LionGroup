package org.example.liongroup.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Icon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String classname;
    @Column(nullable = false)
    private String svgcode;
    @ManyToMany
    private List<Category> categoryId;
    @CreatedDate
    private LocalDateTime createdDAte=LocalDateTime.now();
    @CreatedDate
    private LocalDateTime updatedDAte=LocalDateTime.now();


}
