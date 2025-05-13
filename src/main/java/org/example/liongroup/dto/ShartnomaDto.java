package org.example.liongroup.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShartnomaDto {
    private String title;
    @Column(nullable = false)
    private String description;
}
