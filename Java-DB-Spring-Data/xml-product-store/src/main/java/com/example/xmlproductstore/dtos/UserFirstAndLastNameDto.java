package com.example.xmlproductstore.dtos;


import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import java.util.Set;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserFirstAndLastNameDto {

    @XmlAttribute(name = "first-name")
    private String firstName;
    @XmlAttribute(name = "last-name")
    private String lastName;


    public UserFirstAndLastNameDto() {
    }

    public UserFirstAndLastNameDto(String firstName, String lastName, Set<ProductsNamePriceAndBuyerDto> soldProducts) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
