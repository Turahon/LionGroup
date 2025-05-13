package org.example.liongroup.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeDto {
    private String title;
    @Column(nullable = false)
    private String description;
    private Long photoId;
    private Long categoryId;
    private Long productID;
    private Long addresseID;
}
