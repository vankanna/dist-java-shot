package edu.wctc.shop.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Data
@NoArgsConstructor
@Table(name="Products")
public class Product {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="price")
    private double price;
    @Column(name="stock")
    private int stock;
    @Column(name="image_file_name")
    private String imageFileName;

}
