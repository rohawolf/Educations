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
		
		System.out.println(member1);
	}
}
