package Test.Time;

public class TimeTest {
    public static void main(String[] args) {
        //TimeMills  时间毫秒
        long callTime = System.currentTimeMillis();

        callTime = System.currentTimeMillis() - callTime;

        System.out.println(callTime);
    }
}
