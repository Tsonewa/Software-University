package com.example.xmlproductstore.dtos;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesInfoDto {

    @XmlAttribute
    private String name;
    @XmlElement(name = "products-count")
    private Integer count;
    @XmlElement(name = "average-price")
    private BigDecimal price;
    @XmlElement(name = "total-revenue")
    private BigDecimal totalRevenue;

    public CategoriesInfoDto() {
    }

    public CategoriesInfoDto(String name, Integer count, BigDecimal price, BigDecimal totalRevenue) {
        this.name = name;
        this.count = count;
        this.price = price;
        this.totalRevenue = totalRevenue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
