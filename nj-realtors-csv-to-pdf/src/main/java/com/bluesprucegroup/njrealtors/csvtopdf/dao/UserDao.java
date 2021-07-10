package com.bluesprucegroup.njrealtors.csvtopdf.dao;

import java.util.List;

import com.bluesprucegroup.njrealtors.csvtopdf.domain.ServiceAccountDataDO;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.Role;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.User;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.UserRole;

/**
 * 
 * @author Ger
 *

public interface UserDao extends CrudRepository<User, Long> {
	User findByUsername(String username);
    User findByEmail(String email);
    List<User> findAll();
}
 */

public interface UserDao {

	public User findByUsername(String username);
    
	public User findByEmail(String email);
    
	public List<User> findAll();
    
	public User createUser(User user, Role role, ServiceAccountDataDO serviceAccountDataDO);
	//public void 
	//public User saveRole(User user, Role role, serviceAccountDataDO serviceAccountDataDO);
	//public User saveUserRole(User user, UserRole userRole, serviceAccountDataDO serviceAccountDataDO);
    

}
