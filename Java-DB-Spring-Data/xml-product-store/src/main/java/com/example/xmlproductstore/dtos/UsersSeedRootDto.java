package com.example.xmlproductstore.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersSeedRootDto {

    @XmlElement(name = "user")
    private List<UserSeedDto> users;

    public UsersSeedRootDto() {
    }

    public UsersSeedRootDto(List<UserSeedDto> users) {
        this.users = users;
    }

    public List<UserSeedDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserSeedDto> users) {
        this.users = users;
    }
}
