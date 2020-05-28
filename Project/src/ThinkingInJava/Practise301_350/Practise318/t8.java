package ThinkingInJava.Practise301_350.Practise318;

public class t8 {
    public static void getSuperClass(Class c) {
        Class test = c.getSuperclass();
        while (test != null) {
            System.out.println(c.getClass() + " is a subclass of" + test);
            test = test.getSuperclass();
        }
    }

    public static void main(String[] args) {
        temp22 t22 = new temp22();

        getSuperClass(t22.getClass());
    }
}
