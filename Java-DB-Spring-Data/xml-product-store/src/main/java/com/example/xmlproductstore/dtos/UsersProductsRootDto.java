package com.example.xmlproductstore.dtos;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Set;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersProductsRootDto {

    @XmlAttribute
    private Integer count;
    @XmlElement(name = "user")
    private List<UserSoldProductsDto> users;

    @XmlElementWrapper(name = "sold-products")
    private Set<ProductsNamePriceAndBuyerDto> soldProducts;

    public UsersProductsRootDto() {
    }

    public UsersProductsRootDto(Integer count, List<UserSoldProductsDto> users, Set<ProductsNamePriceAndBuyerDto> soldProducts) {
        this.count = count;
        this.users = users;
        this.soldProducts = soldProducts;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<UserSoldProductsDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserSoldProductsDto> users) {
        this.users = users;
    }

    public Set<ProductsNamePriceAndBuyerDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<ProductsNamePriceAndBuyerDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}