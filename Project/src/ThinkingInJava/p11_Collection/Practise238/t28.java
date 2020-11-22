package ThinkingInJava.p11_Collection.Practise238;

import java.util.PriorityQueue;
import java.util.Random;

public class t28 {
    private static PriorityQueue<Double> PQ = new PriorityQueue<>();

    public static void main(String[] args) {
        Random r = new Random(33);

        for (double i = 0; i < 6; i++)
            PQ.offer(i);
        for (double i = 0; i < 6; i++)
            System.out.println(PQ.poll());
    }
}
