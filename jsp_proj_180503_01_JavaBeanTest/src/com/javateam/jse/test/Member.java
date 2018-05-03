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
	

	
}
