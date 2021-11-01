package com.example.pathfinder.models.enums.entities;

import com.example.pathfinder.models.enums.RoleEnum;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    public Role() {
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }
}
