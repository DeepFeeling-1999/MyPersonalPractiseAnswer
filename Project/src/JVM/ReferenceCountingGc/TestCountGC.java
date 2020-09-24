package JVM.ReferenceCountingGc;

/**
 * VM Args: -XX:+PrintGC
 */
public class TestCountGC {
    public Object instance =null;
    private static final int _1MB=1024*1024;

    private byte[]bigSize=new byte[2*_1MB];
    public static void main(String[]args){
        TestCountGC objA=new TestCountGC();
        TestCountGC objB=new TestCountGC();

        objA.instance=objB;
        objB.instance=objA;


        System.gc();
    }
}
