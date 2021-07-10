package com.bluesprucegroup.njrealtors.csvtopdf.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.bluesprucegroup.njrealtors.csvtopdf.dao.UserRoleDao;
import com.bluesprucegroup.njrealtors.csvtopdf.dao.impl.sql.UserSql;
import com.bluesprucegroup.njrealtors.csvtopdf.dao.rowmapper.UserDaoRowMapper;
import com.bluesprucegroup.njrealtors.csvtopdf.dao.rowmapper.UserRoleDaoRowMapper;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.ServiceAccountDataDO;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.Role;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.User;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.UserRole;

@Component
public class UserRoleDaoImpl implements UserRoleDao {
	private static final Logger log = LogManager.getLogger(UserRoleDaoImpl.class);
	@Autowired
	@Qualifier("devopsJdbcTemplate")
	private JdbcTemplate devopsJdbcTemplate;
	
	@Autowired
	private UserSql userSql;
	
	@Override
	public UserRole findUserRole(User user) {
		UserRole userRole = null;
		try {
			String sql = this.userSql.findUserRoleByUserId(user.getUserId().toString());
			userRole = this.devopsJdbcTemplate.queryForObject(sql, new UserRoleDaoRowMapper()); 
			
		} catch(org.springframework.dao.EmptyResultDataAccessException e) { 
			log.info("Unable to find user: " + user.getUsername());
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return userRole;
	}

	@Override
	public Role saveUserRole(User user, UserRole userRole, ServiceAccountDataDO serviceAccountDataDO) {
		// TODO Auto-generated method stub
		return null;
	}

}
