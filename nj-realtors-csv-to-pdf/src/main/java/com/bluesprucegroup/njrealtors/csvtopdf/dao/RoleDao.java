package com.bluesprucegroup.njrealtors.csvtopdf.dao;

import java.util.List;

import com.bluesprucegroup.njrealtors.csvtopdf.domain.ServiceAccountDataDO;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.Role;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.User;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.UserRole;

public interface RoleDao {
	
	public List<Role> findAllRoles();
	
	public Role findRoleByRoleID(long id);
	
	public Role findRoleByRoleName(String roleName);
	
	public Role saveRole(User user, Role role, ServiceAccountDataDO serviceAccountDataDO);
}
