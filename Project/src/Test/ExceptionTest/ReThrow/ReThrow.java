package Test.ExceptionTest.ReThrow;

import java.util.Random;

class temp1 extends Exception {
    @Override
    public String getMessage() {
        return "temp1 getMessage 666" + super.getMessage();
    }
}

class temp2 extends Exception {
    @Override
    public String getMessage() {
        return "temp2 getMessage" + super.getMessage();
    }
}

class temp3 extends Exception {
    @Override
    public String getMessage() {
        return "temp3 getMessage" + super.getMessage();
    }

    public String toString() {
        return "temp3 toString";
    }
}

public class ReThrow {
    public static void fun(int choice) {
        try {
            switch (choice) {
                case 1:
                    throw new temp1();
                case 2:
                    throw new temp2();
                case 3:
                    throw new temp3();
            }
        } catch (Exception e)     //全部捕获，再重新抛出
        {
            System.out.println("包装进RuntimeException，然后抛出，沿着栈上冒，后用getCause处理");
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Throwable {
        Random r = new Random(33);
        try {
            fun(3);
        } catch (RuntimeException e) {     //用运行时异常接收，然后用getCause得到具体再进行处理
            try {
                throw e.getCause();
            } catch (temp1 t1) {
                System.out.println("catch temp1 t1 ******  " + t1);
            } catch (temp2 t2) {
                System.out.println("catch temp1 t2 ******  " + t2);
            } catch (temp3 t3) {
                System.out.println("catch temp1 t3 ******  " + t3);
            }
        }finally {
            System.out.println("finally");
        }

        System.out.println("666");
    }
}