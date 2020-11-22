package ThinkingInJava.p14_TypeInformation.Practise318;

public class t10 {
    public static void main(String[] args) {
        char[] c = new char[10];

        System.out.println("superClass of char[] c : " + c.getClass().getSuperclass());

        System.out.println("c.instanceof object " + (c instanceof Object));
    }
}
