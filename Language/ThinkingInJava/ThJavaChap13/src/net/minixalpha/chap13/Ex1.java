package net.minixalpha.chap13;

class WaterSource {
	private String s;

	WaterSource() {
		System.out.println("WaterSource()");
		s = "Constructed";
	}

	public String toString() {
		return s;
	}
}

class SprinklerSystem {
	private String valve1, valve2, valve3, valve4;
	private WaterSource source = new WaterSource();
	private int i;
	private float f;

	public String toString() {
		return "valve1 = " + valve1 + " " + "valve2 = " + valve2 + " "
				+ "valve3 = " + valve3 + " " + "valve4 = " + valve4 + "\n"
				+ "i = " + i + " " + "f = " + f + " " + "source = " + source;
	}

}

/**
 *  public java.lang.String toString();
    Code:
       0: new           #32                 // class java/lang/StringBuilder
       3: dup           
       4: ldc           #34                 // String valve1 = 
       6: invokespecial #36                 // Method java/lang/StringBuilder."<init>":(Ljava/lang/String;)V
       9: aload_0       
      10: getfield      #39                 // Field valve1:Ljava/lang/String;
      13: invokevirtual #41                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      16: ldc           #45                 // String  
      18: invokevirtual #41                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      21: ldc           #47                 // String valve2 = 
      23: invokevirtual #41                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      26: aload_0       
      27: getfield      #49                 // Field valve2:Ljava/lang/String;
      30: invokevirtual #41                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      33: ldc           #45                 // String  
      35: invokevirtual #41                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      38: ldc           #51                 // String valve3 = 
      40: invokevirtual #41                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      43: aload_0       
      44: getfield      #53                 // Field valve3:Ljava/lang/String;
      47: invokevirtual #41                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      50: ldc           #45                 // String  
      52: invokevirtual #41                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      55: ldc           #55                 // String valve4 = 
      57: invokevirtual #41                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      60: aload_0       
      61: getfield      #57                 // Field valve4:Ljava/lang/String;
      64: invokevirtual #41                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      67: ldc           #59                 // String \n
      69: invokevirtual #41                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      72: ldc           #61                 // String i = 
      74: invokevirtual #41                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      77: aload_0       
      78: getfield      #63                 // Field i:I
      81: invokevirtual #65                 // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
      84: ldc           #45                 // String  
      86: invokevirtual #41                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      89: ldc           #68                 // String f = 
      91: invokevirtual #41                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      94: aload_0       
      95: getfield      #70                 // Field f:F
      98: invokevirtual #72                 // Method java/lang/StringBuilder.append:(F)Ljava/lang/StringBuilder;
     101: ldc           #45                 // String  
     103: invokevirtual #41                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
     106: ldc           #75                 // String source = 
     108: invokevirtual #41                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
     111: aload_0       
     112: getfield      #24                 // Field source:Lnet/minixalpha/chap13/WaterSource;
     115: invokevirtual #77                 // Method java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
     118: invokevirtual #80                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
     121: areturn     
 *
 */

public class Ex1 {

	public static void main(String[] args) {
		SprinklerSystem sprinklers = new SprinklerSystem();
		System.out.println(sprinklers);
	}

}
