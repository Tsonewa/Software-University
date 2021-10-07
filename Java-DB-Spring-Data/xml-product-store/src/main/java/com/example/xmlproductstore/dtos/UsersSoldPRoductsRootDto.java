package com.example.xmlproductstore.dtos;

import javax.xml.bind.annotation.*;
import java.util.Set;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersSoldPRoductsRootDto {

    @XmlElement(name = "user")
    private Set<UserFirstAndLastNameDto> users;

    public UsersSoldPRoductsRootDto() {
    }

    public UsersSoldPRoductsRootDto(Set<UserFirstAndLastNameDto> users) {
        this.users = users;
    }

    public Set<UserFirstAndLastNameDto> getUsers() {
        return users;
    }

    public void setUsers(Set<UserFirstAndLastNameDto> users) {
        this.users = users;
    }
}
