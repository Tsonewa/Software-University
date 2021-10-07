package com.example.xmlproductstore.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsSeedRootDto {

    @XmlElement(name = "product")
    private List<ProductsSeedDto> products;

    public ProductsSeedRootDto() {
    }

    public ProductsSeedRootDto(List<ProductsSeedDto> products) {
        this.products = new ArrayList<>();
    }

    public List<ProductsSeedDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsSeedDto> products) {
        this.products = products;
    }
}
