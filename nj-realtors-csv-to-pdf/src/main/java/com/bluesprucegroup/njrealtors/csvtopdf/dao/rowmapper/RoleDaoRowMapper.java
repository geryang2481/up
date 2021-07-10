package com.bluesprucegroup.njrealtors.csvtopdf.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.Role;

public class RoleDaoRowMapper implements RowMapper<Role>{

	private static final Logger log = LogManager.getLogger(RoleDaoRowMapper.class);
			
	@Override
	public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Role role = null;
		
		try {
			role = new Role();
			role.setRoleId(rs.getInt("RoleID"));
			role.setName(rs.getString("Role"));
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		
		return role;
	}

}
