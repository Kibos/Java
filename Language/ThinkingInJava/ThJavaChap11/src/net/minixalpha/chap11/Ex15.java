
package net.minixalpha.chap11;

import java.util.Stack;

public class Ex15 {

	public static void main(String[] args) {
		Stack<Character> stack = new Stack<>();
		char[] chars ="+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s---".toCharArray();
		
		for (int i=0; i<chars.length; i++) {
			if (chars[i] == '+') {
				if (Character.isLetter(chars[++i])) {
					stack.push(chars[i]);
				}
			} else if (chars[i] == '-') {
				System.out.print(stack.pop());
			}
		}
	}

}
