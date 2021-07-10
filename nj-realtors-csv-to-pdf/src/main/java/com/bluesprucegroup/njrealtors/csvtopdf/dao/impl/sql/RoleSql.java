package com.bluesprucegroup.njrealtors.csvtopdf.dao.impl.sql;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class RoleSql implements Serializable{

	private static final long serialVersionUID = 1L;

	public String findAll() {
		/*
		 SELECT 
		 	[RoleID]
      		,[Role]
  		FROM 
  			[Role]
		 */
		
		return "SELECT [RoleID], [Role] FROM [Role]";
	}

	public String findByRoleID(String id) {
		/*
		 SELECT 
		 	[RoleID]
     		,[Role]
 		FROM 
 			[Role]
 		WHERE
 			[RoleID] = 'RoleID'
		 */
		
		return "SELECT [RoleID], [Role] FROM [Role] WHERE [RoleID] = '" + id + "'";
	}

	public String findByRoleName(String roleName) {
		/*
		 SELECT 
		 	[RoleID]
     		,[Role]
 		FROM 
 			[Role]
 		WHERE
 			[Role] = 'roleName'
		 */
		
		return "SELECT [RoleID], [Role] FROM [Role] WHERE [Role] = '" + roleName + "'";
	}

}
