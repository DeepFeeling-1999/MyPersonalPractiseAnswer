package ThinkingInJava.p13_string.Practise297;

public class t8 {
    public static String test = "aaa66bbcb ccc ddd eee fff";

    public static void main(String[] args) {
        String[] ar = test.split("[b]");
        // System.out.println(t3.replaceAll("[aeiouAEIOU]","_"));
        for (String st : ar) {
            System.out.println(st);
        }
    }
}
