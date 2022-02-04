package com.jalalshokouh.testspring.modules.users.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Roles implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String role;

    @ManyToMany(mappedBy = "roles")
    private List<Users> usersList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }
}
