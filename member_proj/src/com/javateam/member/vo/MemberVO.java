/**
 * 
 */
package com.javateam.member.vo;

import java.util.Date;

/**
 * VO : Entity
 * @author Roha Park
 *
 */
public class MemberVO {
	
	// Member Fields
	private	String	id;			//id
	private	String	pw;			//pw
	private	String	name;		//name
	private	String	address;	//address
	private	Date	joindate;	//join date
	
	// Constructors
	
	public MemberVO() {}

	/**
	 * constructor with not null parameters
	 * @param id	id
	 * @param pw	password		
	 * @param name	name
	 */
	public MemberVO(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	/**
	 * constructor with all parameters
	 * @param id		id
	 * @param pw		password
	 * @param name		name
	 * @param address	address
	 * @param joindate	join date
	 */
	public MemberVO(String id, String pw, String name, String address, Date joindate) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.address = address;
		this.joindate = joindate;
	}

	/**
	 * check the values of Member Fields of 'MemberVO' class
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("MemberVO [id=%s, pw=%s, name=%s, address=%s, joindate=%s]", id, pw, name,
				address, joindate);
	}

	/**
	 * get hashcode of the instance of 'MemberVO' class
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
	 * compare two instances
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof MemberVO)) {
			return false;
		}
		MemberVO other = (MemberVO) obj;
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (joindate == null) {
			if (other.joindate != null) {
				return false;
			}
		} else if (!joindate.equals(other.joindate)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (pw == null) {
			if (other.pw != null) {
				return false;
			}
		} else if (!pw.equals(other.pw)) {
			return false;
		}
		return true;
	}
	
	// getters / setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}	
	
}
