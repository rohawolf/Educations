/**
 * 
 */
package com.javateam.jse.domain;

import java.util.Date;

/**
 * VO(Value object) : Entity => DB table 1:1 mapping
 * @author Roha Park
 *
 */
public class MemberVO {
	// Member Fields : For Encapsulation
	private String 	id;
	private String 	pw;
	private String 	name;
	private String 	address;
	private	Date	joindate;
	
	// constructors
	public MemberVO() {}

	/**
	 * overloaded constructor : initialize Member Fields (setter"s")
	 * @param id		id
	 * @param pw		password
	 * @param name		name
	 * @param address	address
	 * @param joindate	join date
	 */
	public MemberVO(String id, 
					String pw, 
					String name, 
					String address, 
					Date joindate) {
		this.id = id;					// id
		this.pw = pw;					// password
		this.name = name;				// name
		this.address = address;			// address
		this.joindate = joindate;		// join date
	}
	
	/**
	 * overrid toString() method : check the contents of MemberVO (getter"s")
	 * @see java.lang.Object#toString() 
	 */
	@Override
	public String toString() {
		return String.format("MemberVO [id=%s, pw=%s, name=%s, address=%s, joindate=%s]", id, pw, name, address,
				joindate);
	}

	/**
	 * return hashCode of this instance.
	 * (if the hashCodes of two instances are equal, the contents of these are also equal.)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((joindate == null) ? 0 : joindate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		return result;
	}

	/**
	 * If the contents of two instances are equal, return true, else false.
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (!(obj instanceof MemberVO)) { return false; }
		MemberVO other = (MemberVO) obj;
		
		if (address == null) {
			if (other.address != null) { return false; }
		} else if (!address.equals(other.address)) { return false; }
		
		if (id == null) {
			if (other.id != null) { return false; }
		} else if (!id.equals(other.id)) { return false; }
		
		if (joindate == null) {
			if (other.joindate != null) { return false; }
		} else if (!joindate.equals(other.joindate)) { return false; }
		
		if (name == null) {
			if (other.name != null) { return false; }
		} else if (!name.equals(other.name)) { return false; }
		
		if (pw == null) {
			if (other.pw != null) { return false; }
		} else if (!pw.equals(other.pw)) { return false; }
		
		return true;
	}
	
	//getters and setters
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }

	public String getPw() { return pw; }
	public void setPw(String pw) { this.pw = pw; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }

	public Date getJoindate() { return joindate; }
	public void setJoindate(Date joindate) { this.joindate = joindate; }
	
	
}
