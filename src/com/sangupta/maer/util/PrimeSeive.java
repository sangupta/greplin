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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * An implementation of prime seive.
 * 
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 29-Aug-2011
 */
public class PrimeSeive {
	
	private boolean[] isPrime = null;
	
	private boolean counted = false;
	
	private int count = 0;
	
	private int maxNumber = -1;

	public PrimeSeive(int maxNumber) {
		this.maxNumber = maxNumber;
		
		// initially assume all integers are prime
		isPrime = new boolean[maxNumber + 1];
		Arrays.fill(isPrime, true);

		// mark non-primes <= N using Sieve of Eratosthenes
		for (int i = 2; i * i <= maxNumber; i++) {

			// if i is prime, then mark multiples of i as nonprime
			// suffices to consider mutiples i, i+1, ..., N/i
			if (isPrime[i]) {
				for (int j = i; i * j <= maxNumber; j++) {
					isPrime[i * j] = false;
				}
			}
		}
	}
	
	public List<Integer> primes() {
		List<Integer> primes = new ArrayList<Integer>();
		int length = isPrime.length;
        for (int i = 2; i < length; i++) {
            if (isPrime[i]) {
            	primes.add(i);
            }
        }
		
        return primes;
	}
	
	public int count() {
		if(counted) {
			return this.count;
		}
		
		int primes = 0;
		int length = isPrime.length;
        for (int i = 2; i < length; i++) {
            if (isPrime[i]) {
            	primes++;
            }
        }
        
        this.count = primes;
        counted = true;
        return this.count;
	}
	
	public boolean isPrime(int number) {
		if(number < 0 || number > this.maxNumber) {
			return false;
		}
		
		return isPrime[number];
	}
	
	public int nextPrime(int number) {
		do {
			number++;
			
			if(number > this.maxNumber) {
				return -1;
			}

			if(isPrime(number)) {
				return number;
			}
		} while(true);
	}
	
	public int previousPrime(int number) {
		do {
			number--;
			
			if(number == 1) {
				return -1;
			}
			
			if(isPrime(number)) {
				return number;
			}
		} while(true);
	}

}
