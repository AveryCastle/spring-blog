package com.practice.github.springblog.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Role> roles;

    private boolean active;

    public User(String username, String password, List<Role> roles, boolean active) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.active = active;
    }
}
