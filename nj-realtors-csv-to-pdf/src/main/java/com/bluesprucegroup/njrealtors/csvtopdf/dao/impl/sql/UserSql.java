package com.bluesprucegroup.njrealtors.csvtopdf.dao.impl.sql;

import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.bluesprucegroup.njrealtors.csvtopdf.domain.ServiceAccountDataDO;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.User;

@Component
public class UserSql implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger log = LogManager.getLogger(UserSql.class);
	
	public String findUserByUsername(String username) {
		/*
		SELECT
			[User].userId
			,[User].username
			,[User].password
			,[User].firstName
			,[User].lastName
			,[User].email
			,[User].phone
		FROM 
			[User] [User]
		WHERE
			[User].username = 'username'
		 */
		
		return "SELECT "
				+ "[User].userId ,"
				+ "[User].username ,"
				+ "[User].password ,"
				+ "[User].firstName ,"
				+ "[User].lastName ,"
				+ "[User].email ,"
				+ "[User].phone "
				+ "FROM "
				+ "[User] [User] "
				+ "WHERE "
				+ "[User].username = '" + username + "' ";
	}

	public String findByEmail(String email) {
		/*
		SELECT
			[User].userId
			,[User].username
			,[User].password
			,[User].firstName
			,[User].lastName
			,[User].email
			,[User].phone
		FROM 
			[User] [User]
		WHERE
			[User].email = 'email'
		 */
		
		return "SELECT "
				+ "[User].userId ,"
				+ "[User].username ,"
				+ "[User].password ,"
				+ "[User].firstName ,"
				+ "[User].lastName ,"
				+ "[User].email ,"
				+ "[User].phone "
				+ "FROM "
				+ "[User] [User] "
				+ "WHERE "
				+ "[User].email = '" + email + "' ";
	}
	
	public String findUserRoleByUserId(String userID) {
		/*
		SELECT
			[User].userId
			,[User].username
			,[User].password
			,[User].firstName
			,[User].lastName
			,[User].email
			,[User].phone
		FROM 
			[UserRole] [UserRole]
		WHERE
			[User].username = 'username'
		 */
		
		return "SELECT "
				+ "[UserRole].userRoleID ,"
				+ "[UserRole].roleID ,"
				+ "[UserRole].userID "
				+ "FROM "
				+ "[UserRole] [UserRole] "
				+ "WHERE "
				+ "[UserRole].userID = '" + userID + "' ";
	}

	public String saveUser(User user, ServiceAccountDataDO serviceAccountDataDO) {
		/*
		INSERT INTO 
			[User] 
			(Email, [Enabled], FirstName, LastName, [Password], Phone, Username) 
		VALUES 
			('${email}', 1, '${FirstName}','${LastName}', '${Password}', '${Phone}', '${Username}');
		 */
		
		String query = "UPDATE INTO "
				+ "[User] "
				+ "(Email, [Enabled], FirstName, LastName, [Password], Phone, Username, UUID, CreatedBy, UpdatedBy) "
				+ "VALUES "
				+ "("
				+ "'" + user.getEmail() + "', "
				+ "'1', "
				+ "'" + user.getFirstName() + "',"
				+ "'" + user.getLastName() + "', "
				+ "'" + user.getPassword() + "', "
				+ "'" + user.getPhone() + "', "
				+ "'" + user.getUsername() + "', "
				+ "'" + "SYSADMIN" + "', "
				+ "'" + "SYSADMIN" + "', "
				+ "'" + "SYSADMIN" + "' "
				+ ")";
		log.info(query);
		
		return query;
	}
	
	public String createUser(User user, ServiceAccountDataDO serviceAccountDataDO) {
		/*
		INSERT INTO 
			[UserRole] 
			(UserID, RoleID)
		VALUES 
			('${UserID}', '${RoleID}');
		 */
		
		return "INSERT INTO [User] (Email, Enabled, FirstName, LastName, Password, Phone, Username, UUID, CreatedBy, UpdatedBy) VALUES "
				+ "("
				+ "'" + user.getEmail() + "', "
				+ "'" + "1" + "', "
				+ "'" + user.getFirstName() + "', "
				+ "'" +  user.getLastName() + "', "
				+ "'" +  user.getPassword() + "', "
				+ "'" +  user.getPhone() + "', "
				+ "'" +  user.getUsername() + "', "
				+ "'" + serviceAccountDataDO.getUuid() + "', "
				+ "'" + "SYSADMIN" + "', "
				+ "'" + "SYSADMIN" + "' "
				+ ")";
	}
	
	
	public String createUserRole(long userID, int roleID, ServiceAccountDataDO serviceAccountDataDO) {
		/*
		INSERT INTO 
			[UserRole] 
			(UserID, RoleID)
		VALUES 
			('${UserID}', '${RoleID}');
		 */
		
		return "INSERT INTO [UserRole] (UserID, RoleID, UUID, CreatedBy, UpdatedBy) VALUES "
				+ "("
				+ "'" + userID + "', "
				+ "'" + roleID + "', "
				+ "'" + "SYSADMIN"+ "', "
				+ "'" + "SYSADMIN" + "', "
				+ "'" + "SYSADMIN" + "' "
				+ ")";
	}
	



}
