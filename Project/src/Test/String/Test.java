package Test.String;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/22
 */
public class Test {
    public static void main(String[] args) {
        String a = "helloword";
        final String b = "hello";
        String d = "hello";
        String c = b + "word";
        String e = d + "word";
        String f = "hello" + "word";
        String g = new String("helloword");
        String h = new String("helloword");


        System.out.println(a == c);
        System.out.println(a == e);
        System.out.println(a == f);
        System.out.println(g == h);


        System.out.println("**********************");


    }
}
