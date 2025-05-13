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
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @ManyToMany
    private List<Photo> photoId;
    @ManyToMany
    private List<Category> categoryId;
    @ManyToMany
    private List<Product> productID;
    @ManyToMany
    private List<Address> addresseID;
    @CreatedDate
    private LocalDateTime createdDate=LocalDateTime.now();
}
