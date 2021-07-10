package com.bluesprucegroup.njrealtors.csvtopdf.service.impl;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.bluesprucegroup.njrealtors.csvtopdf.dao.RoleDao;
import com.bluesprucegroup.njrealtors.csvtopdf.dao.UserDao;
import com.bluesprucegroup.njrealtors.csvtopdf.dao.UserRoleDao;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.ServiceAccountDataDO;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.Role;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.User;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.UserRole;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.WebServiceCryptoUtil;
import com.bluesprucegroup.njrealtors.csvtopdf.service.UserService;

@Component
public class UserServiceImpl implements UserService{
	
	private static final Logger log = LogManager.getLogger(UserSecurityServiceImpl.class);
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	@SuppressWarnings("unused")
	@Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }
    
    
    public User createUser(User user, Role role, Set<UserRole> userRoles, ServiceAccountDataDO serviceAccountDataDO) {
        User localUser = userDao.findByUsername(user.getUsername());

        if (localUser != null) {
        	log.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
        } else {
            String encryptedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);

            for (UserRole ur : userRoles) {
                userRoleDao.saveUserRole(user, ur, serviceAccountDataDO);
            }

            user.getUserRoles().addAll(userRoles);

          

            localUser = userDao.createUser(user, role, serviceAccountDataDO);
        }

        return localUser;
    }
    
    public boolean checkUserExists(String username, String email){
    	   if (checkUsernameExists(username) || checkEmailExists(username)) {
               return true;
           } else {
               return false;
           }
    }

    public boolean checkUsernameExists(String username) {
        if (null != findByUsername(username)) {
            return true;
        }

        return false;
    }
    
    public boolean checkEmailExists(String email) {
        if (null != findByEmail(email)) {
            return true;
        }

        return false;
    }

    public User saveRole (User user, Role role, ServiceAccountDataDO serviceAccountDataDO) {
        //return roleDao.saveRole(user, role, serviceAccountDataDO);
    	return null;
    }
    
    public Role saveUserRole(User user, UserRole userRole, ServiceAccountDataDO serviceAccountDataDO) {
    	 return userRoleDao.saveUserRole(user, userRole, serviceAccountDataDO);
    }
    
    public List<User> findUserList() {
        return userDao.findAll();
    }

    public void enableUser (String username) {
        User user = findByUsername(username);
        user.setEnabled(true);
        //userDao.save(user);
        
    }

    public void disableUser (String username) {
        User user = findByUsername(username);
        user.setEnabled(false);
        log.info(user.isEnabled());
        //userDao.save(user);
        log.info(username + " is disabled.");
    }
    

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createUserWithUserRoleSet(User user, Role role, Set<UserRole> userRoles,
			ServiceAccountDataDO serviceAccountDataDO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createUserWithRole(User user, Role role, ServiceAccountDataDO serviceAccountDataDO) {
		//String encryptedPassword = passwordEncoder.encode(user.getPassword());
		BCryptPasswordEncoder encoder = WebServiceCryptoUtil.passwordEncoder();//.encode(user.getPassword());
		String encryptedPassword = encoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        user = userDao.createUser(user, role, serviceAccountDataDO);//(user);
		return user;
	}
}
