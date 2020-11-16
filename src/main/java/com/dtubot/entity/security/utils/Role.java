package com.dtubot.entity.security.utils;



import com.dtubot.entity.security.constant.ERoleName;
import com.dtubot.entity.security.user.User;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "_role")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(name = "role_name")
    private ERoleName roleName;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles", cascade = CascadeType.DETACH)
    Set<User> userSet = new HashSet<User>();

    public Role() {
    }

    public Role(ERoleName eRoleName) {
        this.roleName = eRoleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ERoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(ERoleName eRoleName) {
        this.roleName = eRoleName;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }
}
