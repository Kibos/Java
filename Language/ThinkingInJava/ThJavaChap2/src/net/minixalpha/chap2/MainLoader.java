package net.minixalpha.chap2;

/**
 * This Class is used to Loader each exercise program
 * @author minix
 *
 */
public class MainLoader {
	
	public static void printTitle(int num) {
		System.out.printf("-------Ex %d------\n", num);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printTitle(1);
		Ex1 ex1 = new Ex1();
		// output: 0 (null)
		System.out.println(ex1.iNum + " " + ex1.iChar);
		
		printTitle(2);
		Ex2.mainStart(null);
		
		printTitle(3);
		Ex3 ex3 = new Ex3();
		
		printTitle(4);
		Ex4 ex4 = new Ex4();
		ex4.i = 47;
		ex4.d = 1.1;
		ex4.b = false;
		
		printTitle(5);
		Ex5 ex5 = new Ex5();
		ex5.i = 47;
		ex5.d = 1.1;
		ex5.b = false;
		System.out.println(ex5.i + " " + ex5.d + " " + ex5.b);
		
		printTitle(6);
		Ex6 ex6 = new Ex6();
		ex6.storage("Ex6");
		
		printTitle(7);
		Ex7 ex7 = new Ex7();
		System.out.println("Before increase: " + ex7.getStaticTestI());
		ex7.increment();
		Ex7.increment();
		System.out.println("After increase: " + ex7.getStaticTestI());;
		
		printTitle(8);
		Ex8 ex81 = new Ex8();
		ex81.increaseStaticI();
		int ex81I = ex81.getStaticI();
		System.out.println("ex81's staticI:" + ex81I);
		Ex8 ex82 = new Ex8();
		ex82.increaseStaticI();
		int ex82I = ex82.getStaticI();
		System.out.println("ex82's staticI:" +ex82I);
		if (ex81I == ex82I) {
			System.out.println("Each object has it's own staticI");
		} else {
			System.out.println("All the objects share a same staticI");
		}
		
		printTitle(9);
		Ex9 ex9 = new Ex9();
		System.out.println(ex9.toString());
		
		printTitle(10);
		Ex10 ex10 = new Ex10();
		ex10.printArgs(args);
		
		printTitle(11);
		Ex11 ex11 = new Ex11();
		System.out.println("Before change: " + ex11.getTheHueOfTheColor());
		ex11.changeTheHueOfTheColor(9);
		System.out.println("After change: " + ex11.getTheHueOfTheColor());
	}

}
