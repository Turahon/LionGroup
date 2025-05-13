package org.example.liongroup.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.liongroup.model.Icon;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDto {
    private String name;
    @Column(nullable = false)
    private String description;
    private Long iconId;
}
