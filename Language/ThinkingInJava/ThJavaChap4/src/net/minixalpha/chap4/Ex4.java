/**
 * @author minix
 * @date Mar 31, 2013 4:56:44 PM
 * @Description 
 * 		Exercise 4: (3) Write a program that uses two nested for loops and the modulus
 *		operator (%) to detect and print prime numbers (integral numbers that are not evenly
 *		divisible by any other numbers except for themselves and 1).
 */

package net.minixalpha.chap4;

public class Ex4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int end = 100;
		for (int i=2; i<=end; i++) {
			boolean isPrime = true;
			for (int j=2; j<i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			System.out.println (i + " is " + ((isPrime == false) ? "not " : "") + "a primer");
		}
	}
}
/**
 Output:
 2 is a primer
3 is a primer
4 is not a primer
5 is a primer
6 is not a primer
7 is a primer
8 is not a primer
9 is not a primer
10 is not a primer
11 is a primer
12 is not a primer
13 is a primer
14 is not a primer
15 is not a primer
16 is not a primer
17 is a primer
18 is not a primer
19 is a primer
20 is not a primer
21 is not a primer
22 is not a primer
23 is a primer
24 is not a primer
25 is not a primer
26 is not a primer
27 is not a primer
28 is not a primer
29 is a primer
30 is not a primer
31 is a primer
32 is not a primer
33 is not a primer
34 is not a primer
35 is not a primer
36 is not a primer
37 is a primer
38 is not a primer
39 is not a primer
40 is not a primer
41 is a primer
42 is not a primer
43 is a primer
44 is not a primer
45 is not a primer
46 is not a primer
47 is a primer
48 is not a primer
49 is not a primer
50 is not a primer
51 is not a primer
52 is not a primer
53 is a primer
54 is not a primer
55 is not a primer
56 is not a primer
57 is not a primer
58 is not a primer
59 is a primer
60 is not a primer
61 is a primer
62 is not a primer
63 is not a primer
64 is not a primer
65 is not a primer
66 is not a primer
67 is a primer
68 is not a primer
69 is not a primer
70 is not a primer
71 is a primer
72 is not a primer
73 is a primer
74 is not a primer
75 is not a primer
76 is not a primer
77 is not a primer
78 is not a primer
79 is a primer
80 is not a primer
81 is not a primer
82 is not a primer
83 is a primer
84 is not a primer
85 is not a primer
86 is not a primer
87 is not a primer
88 is not a primer
89 is a primer
90 is not a primer
91 is not a primer
92 is not a primer
93 is not a primer
94 is not a primer
95 is not a primer
96 is not a primer
97 is a primer
98 is not a primer
99 is not a primer
100 is not a primer
*/
