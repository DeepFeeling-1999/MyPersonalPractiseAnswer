package CoreJava.Chapter8_Generic.GenericReflection;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Scanner;

public class GenericReflectionTest
{
    public static void main(String[] args)
    {
        // read class name from command line args or user input
        String name;
        if (args.length > 0)
            name = args[0];
        else
        {
            try (Scanner in = new Scanner(System.in))
            {
                System.out.println("Enter class name (e.g. java.util.Collections): ");
                name = in.next();
            }
        }

        try
        {
            /**
             * 如果只指定了<?>，而没有extends，则默认是允许Object及其下的任何Java类了。也就是任意类。
             */
            Class<?> cl = Class.forName(name);
            printClass(cl);

            for (Method m : cl.getDeclaredMethods())
                printMethod(m);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    //如果只指定了<?>，而没有extends，则默认是允许Object及其下的任何Java类了。也就是任意类。
    public static void printClass(Class<?> cl)
    {
        System.out.print(cl);
        printTypes(cl.getTypeParameters(), "<", ", ", ">", true);

        Type sc = cl.getGenericSuperclass();
        if (sc != null)
        {
            System.out.print(" extends ");
            printType(sc, false);
        }
        printTypes(cl.getGenericInterfaces(), " implements ", ", ", "", false);
        System.out.println();
    }

    public static void printMethod(Method m)
    {
        String name = m.getName();
        System.out.print(Modifier.toString(m.getModifiers()));
        System.out.print(" ");
        printTypes(m.getTypeParameters(), "<", ", ", "> ", true);

        printType(m.getGenericReturnType(), false);
        System.out.print(" ");
        System.out.print(name);
        System.out.print("(");
        printTypes(m.getGenericParameterTypes(), "", ", ", "", false);
        System.out.println(")");
    }

    public static void printTypes(Type[] types, String pre, String sep, String suf,
                                  boolean isDefinition)
    {
        /*Object是所有类的父类，Object.class表示所有类类型的Class，
        // Type 是 Java 编程语言中所有类型的公共高级接口。
        // 它包括Class类，描述具体类型
        // TypeVariable接口，描述参数类型变量，如T extends Comparable<? super T>
        // WildcardType接口，描述通配符，如 ? super T。
        // ParameterizedType接口，描述泛型类，或接口类型，如 Comparable<? super T>
        //GenericArrayType，描述了泛型数组，如 T[]

        // 这里检验它就是为了确保这个type有且仅有一个类的Class，而不是其他的数组等类型*/
        if (pre.equals(" extends ") && Arrays.equals(types, new Type[]{Object.class }))
            return;

        if (types.length > 0)
            System.out.print(pre);

        for (int i = 0; i < types.length; i++)
        {
            if (i > 0)
                System.out.print(sep);

            printType(types[i], isDefinition);
        }
        if (types.length > 0)
            System.out.print(suf);
    }

    public static void printType(Type type, boolean isDefinition)
    {

        // 它包括Class类，描述具体类型
        if (type instanceof Class)
        {
            Class<?> t = (Class<?>) type;
            System.out.print(t.getName());
        }

        // TypeVariable接口，描述参数类型变量，如T extends Comparable<? super T>
        else if (type instanceof TypeVariable)
        {
            TypeVariable<?> t = (TypeVariable<?>) type;
            System.out.print(t.getName());
            if (isDefinition)
                printTypes(t.getBounds(), " extends ", " & ", "", false);
        }

        // WildcardType接口，描述通配符，如 ? super T。
        else if (type instanceof WildcardType)
        {
            WildcardType t = (WildcardType) type;
            System.out.print("?");
            printTypes(t.getUpperBounds(), " extends ", " & ", "", false);
            printTypes(t.getLowerBounds(), " super ", " & ", "", false);
        }

        // ParameterizedType接口，描述泛型类，或接口类型
        else if (type instanceof ParameterizedType)
        {
            ParameterizedType t = (ParameterizedType) type;
            Type owner = t.getOwnerType();
            if (owner != null)
            {
                printType(owner, false);
                System.out.print(".");
            }
            printType(t.getRawType(), false);
            printTypes(t.getActualTypeArguments(), "<", ", ", ">", false);
        }


        else if (type instanceof GenericArrayType)
        {
            GenericArrayType t = (GenericArrayType) type;
            System.out.print("");
            printType(t.getGenericComponentType(), isDefinition);
            System.out.print("[]");
        }
    }
}

