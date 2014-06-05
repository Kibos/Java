package net.minixalpha.chap18;

import java.io.*;

import static net.mindview.util.Print.*;

class Blip1 implements Externalizable {
	public Blip1() {
		print("Blip1 Constructor");
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		print("Blip1.writeExternal");
	}

	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		print("Blip1.readExternal");
	}
}

public class Ex28 implements Externalizable {
	// Ex28() {
	// print("Blip2 Constructor");
	// }

	public void writeExternal(ObjectOutput out) throws IOException {
		print("Ex28.writeExternal");
	}

	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		print("Ex28.readExternal");
	}

	public static void main(String[] args) {
		// Explanation: Ex28 has a defautl public constructor
	}
}

class Blips {
	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		print("Constructing objects:");
		Blip1 b1 = new Blip1();
		Ex28 b2 = new Ex28();
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(
				"Blips.out"));
		print("Saving objects:");
		o.writeObject(b1);
		o.writeObject(b2);
		o.close();
		// Now get them back:
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				"Blips.out"));
		print("Recovering b1:");
		b1 = (Blip1) in.readObject();
		// OOPS! Throws an exception:
		print("Recovering b2:");
		b2 = (Ex28) in.readObject();
	}
}
