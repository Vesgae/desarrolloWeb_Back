package com.javeriana.library.entity;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name="last_name")
    private String last_name;
    @JsonFormat(pattern="dd/MM/yy")
    private Date birthday;
    private String role;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(Long ID, String name, String last_name, Date birthday, String role) {
        this.id = ID;
        this.name = name;
        this.last_name = last_name;
        this.birthday = birthday;
        this.role = role;
    }

    public User(Long id, String name, String last_name, Date birthday, String role, String password) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.birthday = birthday;
        this.role = role;
        this.password = password;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long ID) {
        this.id = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String lastName) {
        this.last_name = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String cargo) {
        this.role = cargo;
    }
}
