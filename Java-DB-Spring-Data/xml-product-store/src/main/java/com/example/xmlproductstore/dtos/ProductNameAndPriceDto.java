package com.example.xmlproductstore.dtos;


import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductNameAndPriceDto {

    @XmlAttribute
    private String name;
    @XmlAttribute
    private BigDecimal price;
    @XmlElementWrapper(name = "sold-products")
    private ProductsSoldWrapper soldProducts;

    public ProductNameAndPriceDto() {
    }

    public ProductNameAndPriceDto(String name, BigDecimal price, ProductsSoldWrapper soldProducts) {
        this.name = name;
        this.price = price;
        this.soldProducts = soldProducts;
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

    public ProductsSoldWrapper getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(ProductsSoldWrapper soldProducts) {
        this.soldProducts = soldProducts;
    }
}
