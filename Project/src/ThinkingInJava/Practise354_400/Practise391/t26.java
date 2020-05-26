package ThinkingInJava.Practise354_400.Practise391;

public class t26 {
    public static void main(String[] args) {
        Number[] ar = new Integer[6];
        ar[0]=Integer.valueOf(6);
        ar[1]= Double.valueOf(3.3);
        System.out.println(ar[0]+"\n"+ar[1]);
        System.out.println(ar[0].getClass().getSimpleName());
        System.out.println(ar[1].getClass().getSimpleName());
    }
}
