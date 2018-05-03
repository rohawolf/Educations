/**
 * 
 */
package com.javateam.jse.test;

import java.util.Date;

/**
 * VO of Table Member
 * @author Roha Park
 *
 */
public class Member {
	
	// Member Fields
	private String	id;
	private	String	pw;
	private	String	name;
	private	int		degree;
	private String	gender;
	private String	homephone;
	private	String	cellphone;
	private String	zipcode;
	private	String	address;
	private	String	mail;
	private	Date	joindate;
	
	// constructors
	
	/**
	 * default constructor of 'Member' class
	 */
	public Member() {}

	/**
	 * constructor using Member Fields of 'Member' class
	 * @param id			id
	 * @param pw			password
	 * @param name			name
	 * @param degree		degree
	 * @param gender		gender
	 * @param homephone		homephone
	 * @param cellphone		cellphone
	 * @param zipcode		zipcode
	 * @param address		address
	 * @param mail			mail
	 * @param joindate		join date
	 */
	public Member(String id, 
				  String pw, 
				  String name, 
				  int degree, 
				  String gender, 
				  String homephone, 
				  String cellphone,
				  String zipcode, 
				  String address, 
				  String mail, 
				  Date joindate) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.degree = degree;
		this.gender = gender;
		this.homephone = homephone;
		this.cellphone = cellphone;
		this.zipcode = zipcode;
		this.address = address;
		this.mail = mail;
		this.joindate = joindate;
	}

	/**
	 * Overrid toString() method for 'Member' class
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"Member [id=%s, pw=%s, name=%s, degree=%s, gender=%s, homephone=%s, cellphone=%s, zipcode=%s, address=%s, mail=%s, joindate=%s]",
				id, pw, name, degree, gender, homephone, cellphone, zipcode, address, mail, joindate);
	}

	/**
	 * Overrid hashCode() method for 'Member' class
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((cellphone == null) ? 0 : cellphone.hashCode());
		result = prime * result + degree;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((homephone == null) ? 0 : homephone.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((joindate == null) ? 0 : joindate.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
		return result;
	}

	/** Overrid equals() method for 'Member' class
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) 								return true;
		if (obj == null)								return false;		
		if (!(obj instanceof Member))					return false;
		
		Member other = (Member) obj;
		if (address == null) {
			if (other.address != null) 					return false;
		} else if (!address.equals(other.address))		return false;
		
		if (cellphone == null) {
			if (other.cellphone != null)				return false;
		} else if (!cellphone.equals(other.cellphone))	return false;
		
		if (degree != other.degree) 					return false;
		
		if (gender == null) {
			if (other.gender != null) 					return false;
		} else if (!gender.equals(other.gender)) 		return false;
		
		if (homephone == null) {
			if (other.homephone != null) 				return false;
		} else if (!homephone.equals(other.homephone))	return false;
		
		if (id == null) {
			if (other.id != null) 						return false;
		} else if (!id.equals(other.id)) 				return false;
		
		if (joindate == null) {					
			if (other.joindate != null) 				return false;
		} else if (!joindate.equals(other.joindate)) 	return false;
		
		if (mail == null) {
			if (other.mail != null) 					return false;
		} else if (!mail.equals(other.mail)) 			return false;
		
		if (name == null) {
			if (other.name != null) 					return false;
		} else if (!name.equals(other.name)) 			return false;
		
		if (pw == null) {
			if (other.pw != null) 						return false;
		} else if (!pw.equals(other.pw)) 				return false;
		
		if (zipcode == null) {
			if (other.zipcode != null) 					return false;
		} else if (!zipcode.equals(other.zipcode)) 		return false;
		
		return true;
	}
	
	//getters and setters
	public String getId() {	return id; }
	public void setId(String id) { this.id = id; }

	public String getPw() { return pw; }
	public void setPw(String pw) { this.pw = pw; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public int getDegree() { return degree; }
	public void setDegree(int degree) { this.degree = degree; }

	public String getGender() { return gender; }
	public void setGender(String gender) { this.gender = gender; } 

	public String getHomephone() { return homephone; }
	public void setHomephone(String homephone) { this.homephone = homephone; }

	public String getCellphone() { return cellphone; }
	public void setCellphone(String cellphone) { this.cellphone = cellphone; }

	public String getZipcode() { return zipcode; }
	public void setZipcode(String zipcode) { this.zipcode = zipcode; }

	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }

	public String getMail() { return mail; }
	public void setMail(String mail) { this.mail = mail; }

	public Date getJoindate() { return joindate; }
	public void setJoindate(Date joindate) { this.joindate = joindate; }
	
}
