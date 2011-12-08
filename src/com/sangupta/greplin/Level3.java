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
import java.util.Arrays;

/**
 * Command line solution to Level 3 of greplin programming challenge.
 *  
 * @author sangupta
 * @since 8 Dec 2011
 */
public class Level3 {
	
	private static int[] numbers;
	
	public static void main(String[] args) throws Exception {
		// get all numbers
		System.out.print("Enter the numbers: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String text = reader.readLine();
		
		String[] tokens = text.split(",");
		numbers = new int[tokens.length];
		for(int index = 0; index < tokens.length; index++) {
			String token = tokens[index].trim();
			int number = Integer.parseInt(token);
			numbers[index] = number;
		}
		
		// sort the numbers if not already sorted
		Arrays.sort(numbers);
		
		// all tokens read
		// find the number of subset
		// divide and rule
		int setCount = 0;
		for(int number : numbers) {
			setCount += waysToSum(number, 0);
		}
		
		// subtract the number of individual numbers
		// single digit sets
		setCount -= numbers.length;
		
		System.out.println("Number of sub-sets: " + setCount);
	}

	private static int waysToSum(int desiredSum, int index) {
		int numberAtIndex = numbers[index];
		if(desiredSum < numberAtIndex) {
			// the required count is less than the number at the index in the array
			// thus we cannot form it
			return 0;
		}
		
		if(desiredSum > numberAtIndex) {
			// we need a sum that is greater than the number at the given index
			// so 
			// 1. check if we can get the desired sum at the next index
			// 2. check if we choose the current number as one of the numbers in the set
			//    then if the difference can be constructed with other numbers available in the set
			return waysToSum((desiredSum - numberAtIndex), index + 1) + waysToSum(desiredSum, index + 1);
		}
		
		// the number required is exactly equal to the desired value
		return 1;
	}
}
