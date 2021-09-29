//package edu.wctc.shop.entity;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Data
//@NoArgsConstructor
//@Table(name="Sales")
//public class Sale {
//    @Id
//    @Column(name="sale_id")
//    private int id;
//
//    @Column(name="total")
//    private double total;
//
//
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "sale_items",
//            joinColumns = { @JoinColumn(name = "order_id", nullable = false, updatable = false)},
//            inverseJoinColumns = { @JoinColumn(name = "product_id", nullable = false, updatable = false)}
//    )
//    private Set<Product> products = new HashSet<>(0);
//
//
//}
