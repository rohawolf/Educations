/**
 * 
 */
package com.javateam.member.util;

import java.util.regex.Pattern;

/**
 * @author Roha Park
 *
 */
public class RegexUtil {
	
	public static boolean isValidRegex(String regex,
									   String target) {		
		return Pattern.compile(regex)
					  .matcher(target)
					  .matches();		
	}
}
