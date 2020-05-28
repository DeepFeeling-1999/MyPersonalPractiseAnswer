package ThinkingInJava.Practise253_300.Practise281;

public class t27 {
    private static int[] ia = new int[2];

    public static void main(String[] args) {
        try {
            ia[2] = 3;
        } catch (ArrayIndexOutOfBoundsException e) { // convert to RuntimeException:
            throw new RuntimeException(e);
        }
    }
}
