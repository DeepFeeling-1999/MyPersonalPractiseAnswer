package JVM.JavaVMStackSOF;

/**
 * VM Args: -Xss128k
 *
 */
public class test {
    private int stackLength=1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }
    public static void main(String[]args){
        test oom=new test();
        try{
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("Stack length: "+oom.stackLength);
            throw e;
        }

    }
}
