package com.example.examprep2.models.entities;

import com.example.examprep2.models.BaseEntity;
import org.hibernate.validator.constraints.CodePointLength;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

@Column(unique = true)
private String name;
@Column(columnDefinition = "TEXT")
private String description;
@Column
@Positive
private BigDecimal price;
@FutureOrPresent
@DateTimeFormat(pattern = "MM/dd/yyyy'T'HH:mm")
private LocalDateTime neededBefore;
@ManyToOne(fetch = FetchType.EAGER)
private Category category;
@ManyToOne(fetch = FetchType.EAGER)
private User user;

    public Product() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public void setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
