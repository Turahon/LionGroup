package org.example.liongroup.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Long categoryId;
}
