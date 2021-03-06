package com.helloworld.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.helloworld.model.DbUser;

/**
 * A custom DAO for accessing data from the database.
 *
 */
public class UserMapper {

	protected static Logger logger = Logger.getLogger("dao");
	
	/**
	 * Simulates retrieval of data from a database.
	 */
	public DbUser searchDatabase(String username) {
		// Retrieve all users from the database
		List<DbUser> users = internalDatabase();
		
		// Search user based on the parameters
		for(DbUser dbUser:users) {
			if ( dbUser.getUsername().equals(username)  == true ) {
				logger.debug("User found");
				// return matching user
				return dbUser;
			}
		}
		
		logger.error("User does not exist!");
		throw new RuntimeException("User does not exist!");
	}

	/**
	 * Our fake database. Here we populate an ArrayList with a dummy list of users.
	 */
	private List<DbUser> internalDatabase() {
		// Dummy database
		
		// Create a dummy array list
		List<DbUser> users = new ArrayList<DbUser>();
		DbUser user = null;
		
		// Create a new dummy user
		user = new DbUser();
		user.setUsername("admin");
		// Actual password: 1234
		user.setPassword("81dc9bdb52d04dc20036dbd8313ed055");
		// Admin user
		user.setAccess(1);
		
		// Add to array list
		users.add(user);
		
		// Create a new dummy user
		user = new DbUser();
		user.setUsername("jane");
		// Actual password: user
		user.setPassword("ee11cbb19052e40b07aac0ca060c23ee");
		// Regular user
		user.setAccess(2);
		
		// Add to array list
		users.add(user);
		
		// Create a new dummy user
		user = new DbUser();
		user.setUsername("jake");
		// Actual password: jake
		user.setPassword("1200cf8ad328a60559cf5e7c5f46ee6d");
		// Regular user
		user.setAccess(1);
		
		// Add to array list
		users.add(user);
		
		// Create a new dummy user
		user = new DbUser();
		user.setUsername("mike");
		// Actual password: sa
		user.setPassword("c12e01f2a13ff5587e1e9e4aedb8242d");
		// Regular user
		user.setAccess(1);
		
		// Add to array list
		users.add(user);
		
		return users;
	}
	
}
