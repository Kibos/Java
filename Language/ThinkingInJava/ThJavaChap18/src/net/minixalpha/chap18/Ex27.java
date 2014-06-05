package net.minixalpha.chap18;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Ex27Demo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5920797990236865890L;
	public Ex27Demo2 demo = new Ex27Demo2();
	public int flag = 2;

}

class Ex27Demo2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6036699368983131371L;

	public int flag = 3;

}

public class Ex27 {
	public static void main(String[] args) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				"Ex27.out"));
		out.writeObject(new Ex27Demo());
		out.close();

		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				"Ex27.out"));
		Ex27Demo demo = (Ex27Demo) in.readObject();
		System.out.println(demo.flag);
		System.out.println(demo.demo.flag);
	}
}
