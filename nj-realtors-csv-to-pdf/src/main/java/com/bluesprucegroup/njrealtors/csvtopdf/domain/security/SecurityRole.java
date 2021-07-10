package com.bluesprucegroup.njrealtors.csvtopdf.domain.security;

import java.util.HashSet;
import java.util.Set;

public class SecurityRole {
	private int roleId;

    private String name;

	private Set<UserRole> userRoles = new HashSet<>();

    public SecurityRole() {

    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
