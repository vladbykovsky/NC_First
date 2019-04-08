package com.example.backend.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "roles", schema = "nc_test", catalog = "")
public class Role {
    private int roleId;
    private String name;
    private Collection<User> usersByRoleId;

    @Id
    @Column(name = "role_id")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role that = (Role) o;
        return roleId == that.roleId &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, name);
    }

//    @OneToMany(mappedBy = "rolesByRoleId")
//    public Collection<UsersEntity> getUsersByRoleId() {
//        return usersByRoleId;
//    }

//    public void setUsersByRoleId(Collection<UsersEntity> usersByRoleId) {
//        this.usersByRoleId = usersByRoleId;
//    }
}
