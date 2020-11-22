package ThinkingInJava.p14_TypeInformation.Practise337;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;


public class t18 {
    private static final Pattern p = Pattern.compile("(\\w+\\.)|\\s*final|\\s*native");

    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("ThinkingInJava.p14_TypeInformation.Practise337.temp");
            Method[] m = c.getDeclaredMethods();
            Constructor<?>[] constructors = c.getDeclaredConstructors();
            for (Method method : m) {
                System.out.println(p.matcher(method.toString()).replaceAll(""));
            }
            for (Constructor<?> constructor : constructors) {
                System.out.println(p.matcher(constructor.toString()).replaceAll(""));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(666);
        }
    }
}
