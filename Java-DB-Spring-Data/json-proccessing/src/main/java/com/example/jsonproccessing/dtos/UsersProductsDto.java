package com.example.jsonproccessing.dtos;

import com.google.gson.annotations.Expose;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersProductsDto {
    @Expose
    private Integer usersCount;
    @Expose
    private List<UsersProductsUsersDto> users;

    public UsersProductsDto() {
    }

    public UsersProductsDto(Integer usersCount, List<UsersProductsUsersDto> users) {
        this.usersCount = usersCount;
        this.users = users;
    }

    public Integer getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(Integer usersCount) {
        this.usersCount = usersCount;
    }

    public List<UsersProductsUsersDto> getUsers() {
        return users;
    }

    public void setUsers(List<UsersProductsUsersDto> users) {
        this.users = users;
    }
}
