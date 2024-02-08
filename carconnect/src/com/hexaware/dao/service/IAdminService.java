package com.hexaware.dao.service;

import com.hexaware.model.Admin;

/**
 * The IAdminService interface provides methods for interacting with the Admin
 * entity. This interface defines operations such as retrieving admin
 * information by ID or username, registering a new admin, updating existing
 * admin details, and deleting an admin.
 */
public interface IAdminService {

	/**
	 * Retrieves admin information by ID.
	 * 
	 * @param adminID The unique identifier of the admin.
	 * @return
	 */
	Admin getAdminByID(int adminID);

	/**
	 * Retrieves admin information by username.
	 * 
	 * @param username The username of the admin.
	 * @return The Admin object corresponding to the username, or null if not found.
	 */
	Admin getAdminByUsername(String username);

	void getAdminByUsernameWithoutReturnType(String username);

	/**
	 * Registers a new admin.
	 * 
	 * @param admin The Admin object containing the details of the new admin to be
	 *              registered.
	 */
	void registerAdmin(Admin admin);

	/**
	 * Updates existing admin details.
	 * 
	 * @param admin The Admin object containing the updated details of the admin.
	 */
	void updateAdmin(Admin admin);

	/**
	 * Deletes an admin by ID.
	 * 
	 * @param adminID The unique identifier of the admin to be deleted.
	 */
	int deleteAdmin(int adminID);

	/**
	 * Retrieves the role of an admin based on the username.
	 * 
	 * @param username The username of the admin.
	 * @return The role of the admin.
	 */
	String getAdminRole(String username);
}
