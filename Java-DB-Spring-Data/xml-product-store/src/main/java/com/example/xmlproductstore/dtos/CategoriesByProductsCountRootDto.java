package com.example.xmlproductstore.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesByProductsCountRootDto {

    @XmlElement(name = "category")
    private Set<CategoriesInfoDto> categories;

    public CategoriesByProductsCountRootDto() {
    }

    public CategoriesByProductsCountRootDto(Set<CategoriesInfoDto> categories) {
        this.categories = categories;
    }

    public Set<CategoriesInfoDto> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoriesInfoDto> categories) {
        this.categories = categories;
    }
}
