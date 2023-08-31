package com.programming3final.bookstore.entity;

import java.util.List;

import org.hibernate.type.descriptor.jdbc.TinyIntJdbcType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    // Fields
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private TinyIntJdbcType enabled;

    // Constructors

    public User() {
    }

    public User(String username, String password, TinyIntJdbcType enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    // Getters and Setters

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TinyIntJdbcType getEnabled() {
        return this.enabled;
    }

    public void setEnabled(TinyIntJdbcType enabled) {
        this.enabled = enabled;
    }

}
