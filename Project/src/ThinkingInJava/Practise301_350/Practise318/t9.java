package ThinkingInJava.Practise301_350.Practise318;

import java.lang.reflect.Field;

public class t9 {
    public static void fun(Class c) {
        Object[] o = c.getDeclaredFields();

        if (o.length == 0) {
            System.err.println("length is zero!");
            System.exit(666);
        } else if (o.length > 0) {
            /*for(Field f:o){

            }*/
        }
    }
}
