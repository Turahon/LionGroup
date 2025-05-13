package org.example.liongroup.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.liongroup.model.Category;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IconDto {
    private String name;
    @Column(nullable = false)
    private String classname;
    @Column(nullable = false)
    private String svgcode;
    @ManyToMany
    private List<Category> categoryId;
}
