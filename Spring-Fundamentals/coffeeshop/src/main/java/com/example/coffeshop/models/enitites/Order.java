package com.example.coffeshop.models.enitites;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity{

    @Column
    @NotBlank
    private String name;
    @Column
    @Positive
    @NotNull
    private BigDecimal price;
    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy'T'HH:mm")
    @PastOrPresent
    @NotNull
    private LocalDateTime time;
    @ManyToOne
    private Category category;
    @Column(columnDefinition = "TEXT")
    @NotBlank
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    private User employee;

    public Order() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }
}
