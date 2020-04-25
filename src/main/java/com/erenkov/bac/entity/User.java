package com.erenkov.bac.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "App_Users", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "APP_USER_UK", columnNames = "username") })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "username", length = 100, nullable = false)
    private String userName;

    @Column(name = "encrypted_password", length = 128, nullable = false)
    private String encrytedPassword;

    @Column(name = "enabled", length = 25, nullable = false)
    private String enabled;

    @Column(name = "statistic", nullable = false)
    private Long statistic;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable (name="User_Roles",
            joinColumns=@JoinColumn (name="User_Id"),
            inverseJoinColumns=@JoinColumn(name="Role_Id"))
    private Set<Role> roles;

    public User() {
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Long getStatistic() {
        return statistic;
    }

    public void setStatistic(Long statistic) {
        this.statistic = statistic;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }
}