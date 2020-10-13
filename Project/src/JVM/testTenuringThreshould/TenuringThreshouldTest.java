package Jvm.testTenuringThreshould;

/**
 * -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
 * -XX:+PrintTenuringDistribution
 */
public class TenuringThreshouldTest {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws InterruptedException {
        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[_1MB / 4];

        allocation2 = new byte[4 * _1MB];

        allocation3 = new byte[4 * _1MB];

        allocation3 = null;

        allocation3 = new byte[4 * _1MB];
    }
}
