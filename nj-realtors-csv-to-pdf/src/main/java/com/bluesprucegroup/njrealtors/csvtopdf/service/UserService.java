package com.bluesprucegroup.njrealtors.csvtopdf.service;

import java.util.List;
import java.util.Set;

import com.bluesprucegroup.njrealtors.csvtopdf.domain.ServiceAccountDataDO;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.Role;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.User;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.UserRole;

public interface UserService {
	public boolean checkUserExists(String username, String email);
	public boolean checkUsernameExists(String username);
	public boolean checkEmailExists(String email);
	public User findByUsername(String username);
	public User findByEmail(String email);
	public User saveUser(User user);
	public User createUserWithUserRoleSet(User user, Role role, Set<UserRole> userRoles, ServiceAccountDataDO serviceAccountDataDO);
	public User createUserWithRole(User user, Role role, ServiceAccountDataDO serviceAccountDataDO) ;
	public List<User> findUserList();
	public void enableUser (String username);
	public void disableUser (String username);
}
