package JVM.HeapOOM;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {
    static class OOMObject{
    }
    public static void main (String[]args) throws InterruptedException {
        List<OOMObject> myList=new ArrayList<>();
        while(true){
            myList.add(new OOMObject());
        }

    }
}
