package com.bluesprucegroup.njrealtors.csvtopdf.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bluesprucegroup.njrealtors.csvtopdf.dao.RoleDao;
import com.bluesprucegroup.njrealtors.csvtopdf.dao.UserDao;
import com.bluesprucegroup.njrealtors.csvtopdf.dao.UserRoleDao;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.Role;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.User;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.UserDomain;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.UserRole;

@Service
public class UserSecurityServiceImpl implements UserDetailsService {

    /** The application logger */
	private static final Logger log = LogManager.getLogger(UserSecurityServiceImpl.class);

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private RoleDao roleDao;
    
    @SuppressWarnings("unused")
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	User user = userDao.findByUsername(username);
    	UserRole userRole = userRoleDao.findUserRole(user);
    	Role role = roleDao.findRoleByRoleID(userRole.getRoleId());
    	userRole.setUser(user);
    	userRole.setRole(role);
    	UserDomain userDomain = new UserDomain();
    	userDomain.getUserRoles().add(userRole);
    	userDomain.setUserId(user.getUserId());
    	userDomain.setUsername(user.getUsername());
    	userDomain.setPassword(user.getPassword());
    	userDomain.setFirstName(user.getFirstName());
    	userDomain.setLastName(user.getEmail());
    	userDomain.setPhone(user.getPhone());
    	userDomain.isEnabled();
        if (null == userDomain) {
        	log.error("Username {} not found", username);
            throw new UsernameNotFoundException("Username " + username + " not found");
        }
        return userDomain;
    }
    
    
    
}
