/**
 *
 * Solutions to Greplin Programming Challenge at http://challenge.greplin.com/
 * Copyright (c) 2011, Sandeep Gupta
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.sangupta.greplin;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Command line solution to Level 1 of greplin programming challenge.
 *  
 * @author sangupta
 * @since 6 Dec 2011
 */
public class Level1 {
	
	public static void main(String[] args) throws Exception {
		System.out.println("Enter the text to find the longest substring palindrome in: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String text = reader.readLine();
		
		// find the longest substring in the text that is also the same in reverse
		String longestPalindrome = null;
		int longestPalindromeLength = 0;
		
		final int length = text.length();
		for(int start = 0; start < length; start++) {
			char startChar = text.charAt(start);
			for(int end = start + 1; end < length; end++) {
				if(text.charAt(end) == startChar) {
					final int subLength = end - start + 1;
					String subString = text.substring(start, end + 1);
					if(isPalindrome(subString, subLength)) {
						if(longestPalindromeLength < subLength) {
							longestPalindromeLength = subLength;
							longestPalindrome = subString;
						}
					}
				}
			}
		}
		
		if(longestPalindrome != null) {
			System.out.println("Longest palindrome found as: " + longestPalindrome);
		} else {
			System.out.println("No palindrome found in the given text.");
		}
	}

	private static boolean isPalindrome(String subString, final int originalLength) {
		int length = originalLength;
		if(length % 2 != 0) {
			length--;
		}
		
		length /= 2;
		
		for(int i = 0; i < length; i++) {
			if(!(subString.charAt(i) == subString.charAt(originalLength - i - 1))) {
				return false;
			}
		}
		
		return true;
	}

}
