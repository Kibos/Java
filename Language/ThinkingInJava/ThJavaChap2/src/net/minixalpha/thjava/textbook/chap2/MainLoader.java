package net.minixalpha.thjava.textbook.chap2;

/**
 * This Class is Used to Load Other Test Case
 * @author zhaoxk
 * @version 0.1
 */
public class MainLoader {

	/**
	 * @param none
	 */
	static void divideSection() {
		System.out.println("------------------------");
	}
	
	/**
	 * Used to Print Name of the Each Test Section
	 * @param title : Name of the Test Section
	 */
	static void printTitle(String title) {
		System.out.println("--------" + title + "----------");
	} 
	
	public static void main(String[] args) {
		// 测试类的作用域
		printTitle("Test Object Scope");
		ObjectScope obj = new ObjectScope();
		obj.testObjectScope();

		
		// 测试类的创建
		// CreateClass 不指明Constructor也会自动有一个
		printTitle("Test Class Create");
		CreateClass ct = new CreateClass();
		System.out.println(ct.toString());
		// 既然不初始化，Java也会给成员变量默认值
		System.out.println(ct.getTestVarOfMember());;
		
		// 测试static成员和非static成员
		printTitle("Test Static Member");
		StaticMember sm1 = new StaticMember();
		StaticMember sm2 = new StaticMember();
		System.out.print("Non Static Member's value after i++ in sm1,sm2: ");
		System.out.print(sm1.IncreaseNonStaticI() + ", ");
		System.out.println(sm2.IncreaseNonStaticI());
		System.out.print("Static Member's value value after i++ in sm1,sm2: ");
		System.out.print(sm1.IncreaseStaticI() + ", ");
		System.out.println(sm2.IncreaseStaticI());
		System.out.println(StaticMember.staticI);
		
		// 打印当前日期
		printTitle("Print Current Date");
		OutputDate.start();
		
		// 打印系统属性
		printTitle("Print Sys Property");
		OutPutSysProperties.start();
	}

}
