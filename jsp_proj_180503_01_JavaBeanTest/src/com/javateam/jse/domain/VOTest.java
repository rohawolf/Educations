/**
 * 
 */
package com.javateam.jse.domain;

import java.util.Date;

/**
 * @author Roha Park
 *
 */
public class VOTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MemberVO member1
			= new MemberVO("rohawolf",
						   "12345678",
						   "Roha Park",
						   "Earth",
						   new Date(System.currentTimeMillis()));
		MemberVO member2
		= new MemberVO("rohawolf",
					   "12345678",
					   "Roha Park",
					   "Earth",
					   new Date(System.currentTimeMillis()));
		
		System.out.println(member1);
		System.out.println(member1.equals(member2));
		System.out.println(member1.hashCode());
		System.out.println(member2.hashCode());
		
		member2.setId("roharoha");
		System.out.println(member1.equals(member2));
		System.out.println(member1.hashCode());
		System.out.println(member2.hashCode());
	}
}
