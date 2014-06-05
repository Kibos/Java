package net.minixalpha.chap18;

import java.util.LinkedList;

import net.mindview.util.OSExecute;

public class Ex22 {
	public static void main(String[] args) {
		// See new version of OSExecute in net/mindview/util/OSExecute.java
		LinkedList<String> result = OSExecute.command("ls");
		System.out.println(result);
	}
}
