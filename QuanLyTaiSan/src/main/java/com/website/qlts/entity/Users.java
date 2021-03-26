package com.website.qlts.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "userName"))
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "Không được để trống")
    @Size(max = 255)
    private String userName;

    @NotEmpty(message = "Không được để trống")
    @Size(max = 255)
    private String passWord;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public Users() {
    }

    public Users(@NotEmpty(message = "Không được để trống") @Size(max = 255) String userName, @NotEmpty(message = "Không được để trống") @Size(max = 255) String passWord, Collection<Role> roles) {

        this.userName = userName;
        this.passWord = passWord;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
