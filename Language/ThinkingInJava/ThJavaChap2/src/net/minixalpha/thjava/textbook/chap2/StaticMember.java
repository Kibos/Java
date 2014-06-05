package net.minixalpha.thjava.textbook.chap2;

public class StaticMember {
	// Integer需要自己初始化，否则默认为null
	static int staticI;
	private int nonStaticI; 
	
	public int IncreaseNonStaticI() {
		nonStaticI = nonStaticI + 1;
		return nonStaticI;
	}
	public void setNonStaticI(int nonStaticI) {
		this.nonStaticI = nonStaticI;
	}
	public static int IncreaseStaticI() {
		staticI = staticI + 1;
		return staticI;
	}
	public static void setStaticI(int staticI) {
		StaticMember.staticI = staticI;
	}
}
