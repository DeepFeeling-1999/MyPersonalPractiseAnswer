package JVM.DirectMemoryOOM;


import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * VM Args:
 * -Xmx20M -XX:MaxDirectMemorySize=10m
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * -Xmx20m -XX:MaxDirectMemorySize=10m -XX:+HeapDumpOnOutOfMemoryError
 */
public class Test {
    private static final int _1MB=1024*1024;

    public static void main(String[]args) throws IllegalAccessException {

       Field unsafeFiled= Unsafe.class.getDeclaredFields()[0];
       unsafeFiled.setAccessible(true);

       Unsafe unsafe=(Unsafe) unsafeFiled.get(null);
       while(true){
           unsafe.allocateMemory(_1MB);
       }
    }
}
