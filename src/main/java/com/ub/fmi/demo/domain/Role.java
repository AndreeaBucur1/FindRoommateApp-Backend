package com.ub.fmi.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role{
    @Id
    private Long id;


    private String name;

    public static final Role ADMIN = new Role("ADMIN");
    public static final Role USER = new Role("USER");

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Role() {

    }

    private Role(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Role other = (Role) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Role [getId()=" + getId() + ", name=" + name + "]";
    }
}
