package CoreJava.Z_Personal.C_5.ArrayList;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<ArrayTest> test = new ArrayList<>();

        test.ensureCapacity(2);//预估最低容量

        test.add(new ArrayTest());
        test.add(new ArrayTest("bbb"));

        test.trimToSize();      //回收多余容量


        ArrayTest[] ar = new ArrayTest[test.size()];
        test.toArray(ar);        //拷贝到一个数组

        for (ArrayTest t : test) {
            System.out.println(t.getName());
        }
        for (ArrayTest t : ar) {
            System.out.println(t.getName());
        }

        System.out.println("***********");
        ar[0] = new ArrayTest("ccc");
        System.out.println("***********");

        for (ArrayTest t : test) {
            System.out.println(t.getName());
        }
        for (ArrayTest t : ar) {
            System.out.println(t.getName());
        }
    }
}

class ArrayTest {
    private String name;

    public ArrayTest() {
        name = "A";
    }

    public ArrayTest(String para) {
        name = para;
    }

    public String getName() {
        return name;
    }
}