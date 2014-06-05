/**
 * @author minix
 * @date Apr 2, 2013 3:57:09 PM
 * @Description:
        Exercise 10: (5) A vampire number has an even number of digits and is formed by
 		multiplying a pair of numbers containing half the number of digits of the result. The digits
  		are taken from the original number in any order. Pairs of trailing zeroes are not allowed.
		Examples include:
		1260 = 21 * 60
		1827 = 21 * 87
		2187 = 27 * 81
		Write a program that finds all the 4-digit vampire numbers. (Suggested by Dan Forhan.)
 */

package net.minixalpha.chap4;

public class Ex10 {
	
	/**
	 * Convert an array to a number, eg:[3,2] to 32
	 * @param bits
	 * @return
	 */
	static int bitsToNum(int[] bits) {
		int len = bits.length;
		int base = 1;
		int sum = 0;
		
		for (int i=len-1; i>=0; i--){
			sum = sum + bits[i]*base;
			base = base * 10;
		}
		
		return sum;
	}
	
	/**
	 * Get factorial of number n
	 */
	static int getFactorial(int n) {
		int factorial = 1;
		for(int i=1; i<=n; i++) {
			factorial *= i;
		}
		return factorial;
	}
	
	/**
	 * Get each elements of an array except the one has index cur
	 */
	static int[] getOthers(int[] eachBit, int cur) {
		int len = eachBit.length;
		int[] result = new int[len-1];
		
		
		for (int i=0, j=0; i<len; i++) {
			if (i != cur) {
				result[j++] = eachBit[i];
			}
		}
		return result;
	}
	
	/**
	 * Get all the possible order of an array
	 * @param eachBit	The array to be interleaves
	 * @param len	Length of the array
	 * @return	All the possible order of the array eachBit
	 */
	static int[][] interleave(int[]eachBit, int len) {
		int num = getFactorial(len);
		int[][] result = new int[num][len];
		
		if (len == 1) {
			result[0][0] = eachBit[0];
			return result;
		}
		
		int index = 0;
		for(int i=0; i<len; i++) {
			int curBit = eachBit[i];
			int[] otherBits = getOthers(eachBit, i).clone();
			int[][] otherBitsInterleave = interleave(otherBits, len-1);
			int obInterLen = otherBitsInterleave.length;
			
			for (int j=0; j<obInterLen; j++) {
				result[index][0] = curBit;
				for (int k=1; k<len; k++) {
					result[index][k] = otherBitsInterleave[j][k-1];
				}
				index = index + 1;
			}
		}
		
		return result;
	}
	
	/**
	 * Get each bit of an integer number
	 * @param n Value of the number
	 * @param len	Length of the number
	 * @return	An array record each bit(decimal) of the number n 
	 */
	
	static int[] getEachBit (int n, int len) {
		int[] eachBit = new int[len];
		int base = 1;
		for (int i=0; i<len; i++) {
			eachBit[i] = n / base % 10;
			base *= 10;
		}
		return eachBit;
	}
	
	/**
	 * Slice an array of type int
	 * @param array	The array to be slice
	 * @param start	Start of the slice
	 * @param end	End of the slice(Not including)
	 * @return	Subarray of array from start to end(not including)
	 */
	static int[] arraySlice(int[] array, int start, int end) {
		int slice[] = new int[end-start];
		for (int i=start, j=0; i<end; i++) {
			slice[j++] = array[i];
		}
		return slice;
	}
	
	/**
	 * Determine whether a number is a vapire number or not
	 * @param n Number to be check
	 * @param len Length of the number
	 * @return	if number is vapire, return true, else return false
	 */
	static boolean isVapireNumber(int n, int len) {
	
		if (len % 2 != 0) {
			System.err.println("Length of " + n + " is not even number");
		} else {
			int[] eachBits = getEachBit(n, len);
			int[][] interLeaves = interleave(eachBits, len);
			int interLen = interLeaves.length;
			for (int i=0; i<interLen; i++ ) {
				int[] curBits = interLeaves[i];
				int[] halfSBits = arraySlice(curBits, 0, len/2);
				int[] halfEBits = arraySlice(curBits, len/2, len);
				int halfSNum = bitsToNum(halfSBits);
				int halfENum = bitsToNum(halfEBits);
				if (halfSNum *halfENum == n) {
					return true;
				}
			}
			
		}
		return false;
	}
	
	/**
	 * Print array of type int
	 * @param array array to be print
	 */
	
	static void printArray(int[] array) {
		for(int num: array) {
			System.out.print(num);
		}
		System.out.println();
	}
	
	/**
	 * Test after each functions written
	 */
	static void test() {
//		int[] eachBit = getEachBit(1260, 4);
//		for(int num: eachBit) {
//			System.out.println(num + " ");
//		}
//		System.out.println();
		
//		System.out.println("3!: " + getFactorial(3));
//		System.out.println("4!: " + getFactorial(4));
		
//		int[] array = {1,2,3};
//		for(int i=0; i<3; i++){
//			printArray(getOthers(array, i));
//		}
		
//		int[] array = {1,2,3,4};
//		int[][] result = interleave(array, 4);
//		int len = result.length;
//		for (int i=0; i<len; i++) {
//			printArray(result[i]);
//		}
		
//		int[] array = {1,2,3};
//		int arrayNum = bitsToNum(array);
//		System.out.println(arrayNum);
		
//		int[] array = {1,2,0,6};
//		printArray(arraySlice(array,0,2));
//		printArray(arraySlice(array,2,4));
		
//		System.out.println(isVapireNumber(1260, 4));
//		System.out.println(isVapireNumber(1827, 4));
//		System.out.println(isVapireNumber(2187, 4));
//		System.out.println(isVapireNumber(1982, 4));
		
	}
	
	public static void main(String[] args) {
		for (int i=1000; i<10000; i++) {
			if (isVapireNumber(i, 4)) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
}
/*
 * Output:
 * 1260 1395 1435 1530 1827 2187 6880 
 */
