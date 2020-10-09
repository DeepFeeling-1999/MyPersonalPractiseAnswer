package A.p8;

public class MyThread implements Runnable {
    String myString = "Yes";

    @Override
    public void run() {
        this.myString = "No";
    }

    public static void main(String[] args) {
        MyThread t = new MyThread();

        new Thread(t,"A").start();
        for (int i = 0; i < 10; i++) {
            System.out.println(t.myString);
        }
    }
}