/**
 * 
 */
package com.roha.user.domain;

/**
 * @author Roha Park
 *
 */
public class User {
	// Member Fields
	String id;
	String name;
	String password;
	
	// getters / setters
	public String getId() {	return id; }
	public void setId(String id) { this.id = id; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }	
}
