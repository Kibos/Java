Compiled from "AtomicityTest.java"
public class AtomicityTest implements java.lang.Runnable {
  public AtomicityTest();
    Code:
       0: aload_0       
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: aload_0       
       5: iconst_0      
       6: putfield      #2                  // Field i:I
       9: return        

  public int getValue();
    Code:
       0: aload_0       
       1: getfield      #2                  // Field i:I
       4: ireturn       

  public void run();
    Code:
       0: aload_0       
       1: invokespecial #3                  // Method evenIncrement:()V
       4: goto          0

  public static void main(java.lang.String[]);
    Code:
       0: invokestatic  #4                  // Method java/util/concurrent/Executors.newCachedThreadPool:()Ljava/util/concurrent/ExecutorService;
       3: astore_1      
       4: new           #5                  // class AtomicityTest
       7: dup           
       8: invokespecial #6                  // Method "<init>":()V
      11: astore_2      
      12: aload_1       
      13: aload_2       
      14: invokeinterface #7,  2            // InterfaceMethod java/util/concurrent/ExecutorService.execute:(Ljava/lang/Runnable;)V
      19: aload_2       
      20: invokevirtual #8                  // Method getValue:()I
      23: istore_3      
      24: iload_3       
      25: iconst_2      
      26: irem          
      27: ifeq          41
      30: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
      33: iload_3       
      34: invokevirtual #10                 // Method java/io/PrintStream.println:(I)V
      37: iconst_0      
      38: invokestatic  #11                 // Method java/lang/System.exit:(I)V
      41: goto          19
}
