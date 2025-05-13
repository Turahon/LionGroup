package org.example.liongroup.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhotoDto {
    private String name;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String size;
}
