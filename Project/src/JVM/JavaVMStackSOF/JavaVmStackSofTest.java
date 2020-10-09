package JVM.JavaVMStackSOF;

/**
 * VM Args: -Xss128k
 *
 */
public class JavaVmStackSofTest {
    private int stackLength=1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }
    public static void main(String[]args){
        JavaVmStackSofTest oom=new JavaVmStackSofTest();
        try{
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("Stack length: "+oom.stackLength);
            throw e;
        }

    }
}
