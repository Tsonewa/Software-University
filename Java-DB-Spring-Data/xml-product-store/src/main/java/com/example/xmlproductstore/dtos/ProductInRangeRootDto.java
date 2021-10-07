package com.example.xmlproductstore.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductInRangeRootDto {

    @XmlElement
    private Set<ProductsInRangeDto> products;

    public ProductInRangeRootDto() {
    }

    public ProductInRangeRootDto(Set<ProductsInRangeDto> products) {
        this.products = products;
    }

    public Set<ProductsInRangeDto> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductsInRangeDto> products) {
        this.products = products;
    }
}
