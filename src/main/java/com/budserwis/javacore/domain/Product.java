package com.budserwis.javacore.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    private Long id;
    private String title;
    private String description;
    private Long price;
    private Integer amount;
    private Category category;

}
