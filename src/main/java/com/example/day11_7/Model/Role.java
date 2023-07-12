package com.example.day11_7.Model;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "discription")
    String discription;

    public Role() {
    }

    public Role(int id, String name, String discription) {
        this.id = id;
        this.name = name;
        this.discription = discription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}
