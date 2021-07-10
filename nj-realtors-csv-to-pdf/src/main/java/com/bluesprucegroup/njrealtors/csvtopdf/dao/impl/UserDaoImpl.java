package com.bluesprucegroup.njrealtors.csvtopdf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.bluesprucegroup.njrealtors.csvtopdf.dao.UserDao;
import com.bluesprucegroup.njrealtors.csvtopdf.dao.impl.sql.UserSql;
import com.bluesprucegroup.njrealtors.csvtopdf.dao.rowmapper.UserDaoRowMapper;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.ServiceAccountDataDO;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.Role;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.User;

@Component
public class UserDaoImpl implements UserDao {

	private static final Logger log = LogManager.getLogger(UserDaoImpl.class);
	
	@Autowired
	@Qualifier("devopsJdbcTemplate")
	private JdbcTemplate devopsJdbcTemplate;
	
	@Autowired
	private UserSql userSql;
	
	@Override
	public User findByUsername(String username) {
		User user = null;
		try {
			user = this.devopsJdbcTemplate.queryForObject(this.userSql.findUserByUsername(username), new UserDaoRowMapper()); 
			
		} catch(org.springframework.dao.EmptyResultDataAccessException e) { 
			log.info("Unable to find user: " + username);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return user;
	}

	@Override
	public User findByEmail(String email) {
		User user = null;
		try {
			user = this.devopsJdbcTemplate.queryForObject(this.userSql.findByEmail(email), new UserDaoRowMapper()); 
		} catch(org.springframework.dao.EmptyResultDataAccessException e) { 
			log.info("Unable to find user: " + email);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return user;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return  null;
	}

	@Override
	public User createUser(User user, Role role, ServiceAccountDataDO serviceAccountDataDO) {
		try {
			String insertUser = this.userSql.createUser(user, serviceAccountDataDO);
			KeyHolder holder = new GeneratedKeyHolder();
			this.devopsJdbcTemplate.update(new PreparedStatementCreator() {           

                @Override
                public PreparedStatement createPreparedStatement(Connection connection)
                        throws SQLException {
                    PreparedStatement ps = connection.prepareStatement(insertUser,
                        Statement.RETURN_GENERATED_KEYS); 
                    return ps;
                }
            }, holder);
			long userID = holder.getKey().longValue();
			this.devopsJdbcTemplate.update(this.userSql.createUserRole(userID, role.getRoleId(), serviceAccountDataDO));
			user.setUserId(1L);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		return user;
	}
/*
	@Override
	public User saveRole(User user, Role role, serviceAccountDataDO serviceAccountDataDO) {
		try {
			//this.devopsJdbcTemplate.update(this.userDaoSql.saveRole(4, 1, serviceAccountDataDO));
			//user.setUserId(1L);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		return user;
	}

	@Override
	public User saveUserRole(User user, UserRole userRole, serviceAccountDataDO serviceAccountDataDO) {
		try {
			this.devopsJdbcTemplate.update(this.userDaoSql.saveUserRole(4, 1, serviceAccountDataDO));
			user.setUserId(1L);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		return user;
	}*/

}
