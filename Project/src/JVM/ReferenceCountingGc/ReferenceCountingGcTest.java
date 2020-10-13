package Jvm.ReferenceCountingGc;

/**
 * VM Args: -XX:+PrintGC
 */
public class ReferenceCountingGcTest {
    public Object instance =null;
    private static final int _1MB=1024*1024;

    private byte[]bigSize=new byte[2*_1MB];
    public static void main(String[]args){
        ReferenceCountingGcTest objA=new ReferenceCountingGcTest();
        ReferenceCountingGcTest objB=new ReferenceCountingGcTest();

        objA.instance=objB;
        objB.instance=objA;


        System.gc();
    }
}
