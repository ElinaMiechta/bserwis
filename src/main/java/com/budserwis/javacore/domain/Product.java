package com.budserwis.javacore.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {

    @Id
    private Long id;
    @Lob
    private byte[] image;
    private String title;
    private String descr;
    private Long price;
    private Integer amount = 0;
    //    private Category category;
    private String category;


    public Product(byte[] img, String title, String description, Long price, String category) {
        this.id = generateId();
        this.image = img;
        this.title = title;
        this.descr = description;
        this.price = price;
        this.amount++;
        this.category = category;
    }

    public Product(String title, String description, Long price, String category) {
        this.id = generateId();
        this.title = title;
        this.descr = description;
        this.price = price;
        this.amount++;
        this.category = category;
    }


    private Long generateId() {
        long leftLimit = 1L;
        long rightLimit = 100L;
        return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
    }


}
