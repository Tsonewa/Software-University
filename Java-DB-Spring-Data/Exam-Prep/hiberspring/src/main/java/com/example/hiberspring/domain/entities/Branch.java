package com.example.hiberspring.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "branches")
public class Branch extends BaseEntity {

    private String name;
    private Town town;

    public Branch() {
    }

    public Branch(String name, Town town) {
        this.name = name;
        this.town = town;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

}
