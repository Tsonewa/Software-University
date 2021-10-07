package com.example.jsonproccessing.entities;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product extends BaseEntity{

    private String name;
    private BigDecimal price;
    private User buyerId;
    private User sellerId;
    private Set<Categories> categories;

    public Product() { }

    public Product(String name, BigDecimal price, User buyerId, User sellerId) {
        this.name = name;
        this.price = price;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.categories = new HashSet<>();
    }

    @Column
    @Size(min = 3)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column
    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    public User getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(User buyerId) {
        this.buyerId = buyerId;
    }

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    public User getSellerId() {
        return sellerId;
    }

    public void setSellerId(User sellerId) {
        this.sellerId = sellerId;
    }

    @ManyToMany
    @JoinTable(name = "products_categories", joinColumns =
    @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    public Set<Categories> getCategories() {
        return categories;
    }

    public void setCategories(Set<Categories> categories) {
        this.categories = categories;
    }
}
