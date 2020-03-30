package com.erenkov.bac.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "App_Role",  uniqueConstraints = { //
                @UniqueConstraint(name = "APP_ROLE_UK", columnNames = "Role_Name") })
public class Role {

    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    @Column(name = "Role_Id", nullable = false)
    private Long roleId;

    @Column(name = "Role_Name", length = 30, nullable = false)
    private String roleName;

    @ManyToMany//(mappedBy = "roles")
    @JoinTable(name="user_roles",
            joinColumns=@JoinColumn(name="User_Id"),
            inverseJoinColumns=@JoinColumn(name="Role_Id"))
    private Set<User> users;

    public Role() {

    }
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}