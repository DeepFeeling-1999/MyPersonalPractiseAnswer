package ThinkingInJava.Practise253_300.Practise297;

public class t7 {
    static String test = "Aasdad+6545 +584 asda .+";

    public static void main(String[] args) {
        System.out.println(test.matches("^[A-Z].*[+]$"));
        System.out.println(test.matches("^[A-Z].*[.]$"));
    }
}
