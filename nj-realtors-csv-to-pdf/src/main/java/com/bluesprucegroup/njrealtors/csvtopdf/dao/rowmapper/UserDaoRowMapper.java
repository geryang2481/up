package com.bluesprucegroup.njrealtors.csvtopdf.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.User;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.UserRole;

public class UserDaoRowMapper implements RowMapper<User>{
	
	private static final Logger log = LogManager.getLogger(UserDaoRowMapper.class);
	
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = null;
        
        try {
	        user = new User();
	        user.setUserId(rs.getLong("userId"));
	        user.setUsername(rs.getString("Username"));
	        user.setFirstName(rs.getString("firstName"));
	        user.setLastName(rs.getString("lastName"));
	        user.setEmail(rs.getString("email"));
	        user.setPhone(rs.getString("phone"));
	        user.setPassword(rs.getString("password"));
        } catch(Exception e) {
        	log.error(e.getMessage(), e);
        }
        
        return user;
    }
	
}
