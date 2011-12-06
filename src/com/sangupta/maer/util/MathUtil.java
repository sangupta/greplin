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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since Jan 6, 2011
 */
public class MathUtil {
	
	public static long sumFirstN(long n) {
		return (n * (n + 1)) / 2;
	}
	
	public static long squareOfSumFirstN(long n) {
		long sumN = sumFirstN(n);
		return sumN * sumN;
	}
	
	public static long sumOfSquaresFirstN(long n) {
		long result = (n * (n + 1) * (2* n + 1)) / 6;
		return result;
	}
	
	public static long sumFirstNDivisibleByM(long n, long m) {
		return sumFirstNDivisibleByM(n, m, true);
	}
	
	public static long sumFirstNDivisibleByM(long n, long m, boolean includeN) {
		if(!includeN) {
			n -= 1;
		}
		return m * sumFirstN(n / m);
	}

	public static boolean isPrime(long n) {
		if(n % 2 == 0) {
			return false;
		}
		
		long num = (long) Math.sqrt(n);
		for(int i = 3; i <= num; i += 2) {
			if(n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static long lcm(long a, long b) {
		return (a * b) / gcd(a, b);
	}
	
	public static long gcd(long a, long b) {
		if(b == 0) {
			return a;
		}
		
		return gcd(b, a % b);
	}

	public static BigInteger raiseToPowerInPrecision(int i, long power, int precision) {
		BigInteger number = BigInteger.valueOf(i);
		BigInteger product = BigInteger.valueOf(1l); 
		for(long l = 0; l < power; l++) {
			product = product.multiply(number);
			
			product = trimToPrecision(product, precision);
		}
		
		return product;
	}
	
	public static BigInteger raiseToPower(int i, long power) {
		BigInteger number = BigInteger.valueOf(i);
		BigInteger product = BigInteger.valueOf(1l); 
		for(long l = 0; l < power; l++) {
			product = product.multiply(number);
		}
		
		return product;
	}

	public static BigInteger trimToPrecision(BigInteger number, int precision) {
		String n = number.toString();
		if(n.length() > precision) {
			n = n.substring(n.length() - precision);
		}
		return new BigInteger(n);
	}

	/**
	 * Returns the sum of all divisors of the given <code>number</code>.
	 * 
	 * @param divSum
	 * @return
	 */
	public static long sumOfDivisors(long num) {
		long sum = 0;
		long root = (long) Math.sqrt((double) num);
		
		if (root * root == num) {
			// case that n is a perfect square
			sum += root;
			root -= 1;
		}

		if (isOdd(num)) {
			for (int i = 1; i <= root; i += 2) {
				if (num % i == 0)
					sum += i + num / i;
			}
		} else {
			// number is even
			for (int i = 1; i <= root; i += 1) {
				if (num % i == 0)
					sum += i + num / i;
			}
		}
		
		return sum;
	}
	
	public static long sumOfProperDivisors(long num) {
		if(num == 1) {
			return 0;
		}
		
		long sum = 1; // as 1 is a divisor and we are considering proper divisors
		long root = (long) Math.sqrt((double) num);
		
		if (root * root == num) {
			// case that n is a perfect square
			sum += root;
			root -= 1;
		}

		if (isOdd(num)) {
			for (int i = 2; i <= root; i += 2) {
				if (num % i == 0)
					sum += i + num / i;
			}
		} else {
			// number is even
			for (int i = 2; i <= root; i += 1) {
				if (num % i == 0)
					sum += i + num / i;
			}
		}
		
		return sum;
	}
	
	public static List<Long> divisors(long number) {
		List<Long> divisors = new ArrayList<Long>();
		
		// the initial value is 1 because 1 is always a factor of every number
		divisors.add(1l);
		
		for(int index = 2; index <= (number / 2); index++) {
			if(number % index == 0) {
				divisors.add(new Long(index));
			}
		}

		return divisors;
	}
	
	public static BigInteger factorial(int number) {
		BigInteger product = BigInteger.valueOf(1l);
		for(int index = 2; index <= number; index++) {
			product = product.multiply(BigInteger.valueOf(index));
		}
		
		return product;
	}
	
	public static List<Long> primeFactors(long n) {
		List<Long> factors = new ArrayList<Long>();
		for (int i = 2; i <= n / i; i++) {
			while (n % i == 0) {
				factors.add((long)i);
				n /= i;
			}
		}
		if (n > 1) {
			factors.add(n);
		}
		return factors;
	}

	public static double[] solveQuadratic(long a, long b, long c) {
		double[] values = new double[2];
		
		double arg = (b * b) - (4 * a * c);
		if(arg < 0) {
			return null;
		}
		
		double quad = Math.sqrt(arg);
		double a2 = 2 * a;
		double bn = 0 - b;
		double x1 = (bn + quad) / a2;
		double x2 = (bn + quad) / a2;
		
		values[0] = x1;
		values[1] = x2;
		
		return values;
	}
	
	public static boolean isPentagonal(int number) {
		double x = 1 + 24 * number;
		x = Math.sqrt(x);
		x += 1;
		x /= 6;
		
		long y = (long) x;
		x -= y;
		
		if(x == 0) {
			return true;
		}
		
		return false;
	}
	
	public static int getPentagonalForIndex(int n) {
		return (n * (3 * n - 1)) / 2;
	}

	/**
	 * @param n
	 * @return
	 */
	public static boolean isPandigital(String num) {
		char[] digits = num.toCharArray();
		Arrays.sort(digits);
		for(int index = 0; index < digits.length; index++) {
			int d = digits[index] - '0';
			if(d != (index + 1)) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * @param ab
	 * @return
	 */
	public static long sumOfDigits(BigInteger ab) {
		String number = ab.toString();
		return sumOfDigits(number);
	}

	/**
	 * @param number
	 * @return
	 */
	public static long sumOfDigits(String number) {
		long sum = 0;
		for(char c : number.toCharArray()) {
			sum += c - '0';
		}
		
		return sum;
	}
	
	/**
	 * 
	 * @param number
	 * @return
	 */
	public static int sumOfDigits(long number) {
		int sum = 0;

		for (; number >= 10; number /= 10) {
			sum += number % 10;
		}

		return sum + (int) number;
	}

	/**
	 * @param i
	 * @return
	 */
	public static boolean isPandigital(long number) {
		String numString = String.valueOf(number);
		return isPandigital(numString);
	}

	/**
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static boolean arePrime(long... array) {
		if(array == null || array.length == 0) {
			throw new IllegalArgumentException("No number specified to be tested for primality.");
		}
		
		for(int index = 0; index < array.length; index++) {
			long number = array[index];
			if(!isPrime(number)) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean isPermutation(int a, int b) {
		String num1 = String.valueOf(a);
		String num2 = String.valueOf(b);
		for(int i = 0; i < num1.length(); i++) {
			char c = num1.charAt(i);
			if(num2.indexOf(c) == -1) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * Tests whether the given number is even or not, uses bit arithmetic.
	 * 
	 * @param diff
	 * @return
	 */
	public static boolean isEven(long number) {
		return (number & 1) == 0;
	}
	
	/**
	 * Tests whether the given number is odd or not, uses bit arithmetic.
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isOdd(long number) {
		return (number & 1) == 1;
	}
	
	public static boolean isBouncy(long number) {
		return isBouncy(String.valueOf(number));
	}
	
	public static boolean isBouncy(BigInteger number) {
		if(number == null) {
			throw new IllegalArgumentException("Number cannot be null.");
		}
		
		return isBouncy(number.toString());
	}
	
	/**
	 * @param number
	 * @return
	 */
	public static boolean isBouncy(String number) {
		char[] chars = number.toCharArray();
		int max = chars.length - 1;
		
		boolean increasing = false, decreasing = false;
		for(int index = 0; index < max; index++) {
			if(!increasing && chars[index + 1] > chars[index]) {
				increasing = true;
			}
			
			if(!decreasing && chars[index + 1] < chars[index]) {
				decreasing = true;
			}
			
			if(increasing && decreasing) {
				return true;
			}
		}
		
		return false;
	}
}
