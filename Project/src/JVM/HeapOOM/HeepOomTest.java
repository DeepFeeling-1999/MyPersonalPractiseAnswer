package JVM.HeapOOM;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeepOomTest {
    static class OOMObject {}

    public static void main(String[] args) throws InterruptedException {
        List<OOMObject> myList = new ArrayList<>();
        while (true) {
            myList.add(new OOMObject());
        }

    }
}
