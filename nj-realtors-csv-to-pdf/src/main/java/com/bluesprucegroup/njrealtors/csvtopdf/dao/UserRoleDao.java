package com.bluesprucegroup.njrealtors.csvtopdf.dao;

import com.bluesprucegroup.njrealtors.csvtopdf.domain.ServiceAccountDataDO;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.Role;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.User;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.UserRole;

public interface UserRoleDao {

	public UserRole findUserRole(User user) ;
	public Role saveUserRole(User user, UserRole userRole, ServiceAccountDataDO serviceAccountDataDO);
}
