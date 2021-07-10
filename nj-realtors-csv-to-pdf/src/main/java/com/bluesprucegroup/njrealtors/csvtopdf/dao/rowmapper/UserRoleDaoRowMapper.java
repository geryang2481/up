package com.bluesprucegroup.njrealtors.csvtopdf.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.UserRole;


public class UserRoleDaoRowMapper implements RowMapper<UserRole> {
	private static final Logger log = LogManager.getLogger(UserRoleDaoRowMapper.class);
	@Override
	public UserRole mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserRole userRole = null;
	        
	        try {
	        	userRole = new UserRole();
	        	userRole.setUserRoleId(rs.getLong("userRoleId"));
	        	userRole.setUserId(rs.getLong("userId"));
	        	userRole.setRoleId(rs.getLong("roleId"));
	        	
	        } catch(Exception e) {
	        	log.error(e.getMessage(), e);
	        }
	        
	        return userRole;
	}

}
