package CoreJava.Chapter5_Extends.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;


public class ReflectionTest {
    public static void main(String[] args) {
        String name;
        if (args.length > 0) {
            name = args[0];
        } else {
            Scanner inTemp = new Scanner(System.in);
            System.out.println("Please enter class name : ");
            name = inTemp.next();           //获取类名
        }

        try {
            Class cl = Class.forName(name);         //调用静态方法forName获得类名对应的class对象
            Class superCl = cl.getSuperclass();     //获得其直接父类
            String modifies = Modifier.toString(cl.getModifiers());
            //调用getModifiers返回一个整型数值，用于判断方法是否是public，private，final
            //调用Modifier.toString方法可以将修饰符转换成字符串，然后打印出来

            if (modifies.length() > 0) {
                System.out.print(modifies + " ");
            }
            System.out.print(" class " + name);
            if (superCl != null && superCl != Object.class)     //class和getClass的区别见测试包
            {
                System.out.print(" extends " + superCl.getName());
            }

            System.out.print("\n{\n");
            printConstructors(cl);
            System.out.println();

            printMethods(cl);
            System.out.println();

            printFields(cl);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    private static void printConstructors(Class cl) {
        //java.lang.reflect包中有三个类Field，Method,Constructor

        Constructor[] constructors = cl.getDeclaredConstructors();
        //getDeclaredConstructors返回类中的全部构造器，包含私有和受保护，但不包括超类成员
        //getConstructors返回类的所有   <公有>  构造器，也包括超类的公有构造器

        for (Constructor temp : constructors) {
            String name = temp.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(temp.getModifiers());
            //调用getModifiers返回一个整型数值，用于判断方法是否是public，private，final
            //调用Modifier.toString方法可以将修饰符转换成字符串，然后打印出来

            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(name + "(");

            Class[] paramTypes = temp.getParameterTypes();
            //返回一个用于描述参数类型的Class对象数组

            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) {
                    System.out.print(", ");
                }
            }
            System.out.println(");");
        }
    }

    private static void printMethods(Class cl) {
        //java.lang.reflect包中有三个类Field，Method,Constructor
        Method[] methods = cl.getDeclaredMethods();
        //getMethods返回类的所有   <公有>  方法，也包括超类的公有成员
        //getDeclaredMethods返回类的所有方法，包含私有和受保护，但是不包括超类成员

        for (Method temp : methods) {
            Class retType = temp.getReturnType();
            //返回一个用于描述返回类型的Class对象，在Method类中

            String name = temp.getName(); //得到方法名称
            System.out.print(" ");

            String modifiers = Modifier.toString(temp.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(retType.getName() + " " + name + "(");

            Class[] paramTypes = temp.getParameterTypes();
            //获得一个用于描述参数类型的Class数组

            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) {
                    System.out.print(", ");
                }
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    private static void printFields(Class cl) {
        //java.lang.reflect包中有三个类Field，Method,Constructor
        Field[] fields = cl.getDeclaredFields();
        //getDeclaredFields返回类声明中的所有域，包含私有及受保护，但不包括超类的成员
        //getFields返回类的所有   <公有>  域，也包括超类的公有域

        for (Field temp : fields) {
            Class type = temp.getType();
            String name = temp.getName();
            System.out.print(" ");
            String modifiers = Modifier.toString(temp.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(type.getName() + " " + name + ";");
        }
    }
}
