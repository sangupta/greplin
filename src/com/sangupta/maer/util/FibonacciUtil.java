/**
 *
 * maer - Solutions to problems of Project Euler
 * Copyright (C) 2011, Sandeep Gupta
 * http://www.sangupta.com/projects/maer
 *
 * The file is licensed under the the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.sangupta.maer.util;

/**
 * As per the Wikipedia page, http://en.wikipedia.org/wiki/Fibonacci_number
 * the following convenience functions have been arrived at.
 * 
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since Jan 6, 2011
 */
public class FibonacciUtil {
	
	private static double psi = (1 + Math.sqrt(5)) /2 ;
	
	public static long getFibonnaci(long i) {
		return (long) ((Math.pow(psi, i) - Math.pow((1 - psi), i)) / Math.sqrt(5));
	}

	public static long sumN(long n) {
		return getFibonnaci(n+2) - 1;
	}
	
	public static long sumNforOddIndices(long n) {
		// divide n by 2
		n = (n - 1) / 2;
		
		return getFibonnaci(2 * n + 2);
	}
	
	public static long sumNforEvenIndices(long n) {
		// divide n by 2
		n = n / 2;
		return getFibonnaci(2 * n + 1) - 1;
	}
	
}
