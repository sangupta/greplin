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

import java.util.List;

import com.sangupta.maer.util.FibonacciUtil;
import com.sangupta.maer.util.MathUtil;
import com.sangupta.maer.util.PrimeUtils;

/**
 * Command line solution to Level 2 of greplin programming challenge. 
 * 
 * @author sangupta
 * @since 6 Dec 2011
 */
public class Level2 {
	
	private static final int MIN_LIMIT = 227000;
	
	public static void main(String[] args) {
		int index = 10;
		long prime = -1;
		do {
			long fib = FibonacciUtil.getFibonnaci(index);
			if(fib > MIN_LIMIT) {
				if(PrimeUtils.isPrime(fib)) {
					prime = fib;
					break;
				}
			}
			index++;
		} while(true);
		
		System.out.println("Found prime as: " + prime);
		long testNumber = prime + 1;
		List<Long> factors = MathUtil.primeFactors(testNumber);
		
		long sum = 0;
		for(Long num : factors) {
			sum += num;
		}
		
		System.out.println("Sum of prime divisors: " + sum);
	}

}
