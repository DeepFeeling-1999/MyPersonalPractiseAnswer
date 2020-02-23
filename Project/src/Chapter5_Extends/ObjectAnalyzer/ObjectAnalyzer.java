package Chapter5_Extends.ObjectAnalyzer;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.lang.reflect.Field;

class ObjectAnalyzer {

    private ArrayList<Object> visited = new ArrayList<>();

    String toString(Object obj)
    {
        if (obj == null)
            return "null";
        if (visited.contains(obj))  //比较内容
            return "...";

        visited.add(obj);
        Class cl = obj.getClass();

        if (cl == String.class)     //当obj是String类型时，cl为  class java.lang.String
            return (String) obj;

        if (cl.isArray())            //判断是否是数组
        {
            StringBuilder r = new StringBuilder(cl.getComponentType() + "[]{");
            //getComponentType返回数组元素对应的class对象

            for (int i = 0; i < Array.getLength(obj); i++)
            {
                if (i > 0)
                    r.append(",");
                Object val = Array.get(obj, i);
                if (cl.getComponentType().isPrimitive())
                    //用来判断Class是否为原始类型
                    //（boolean、char、byte、short、int、long、float、double）
                    r.append(val);
                else
                    r.append(toString(val));
            }
            return r + "}";
        }

        StringBuilder r = new StringBuilder(cl.getName());
       //获得类名，用StringBuilder便于删改，StringBuffer额外保证线程安全
        do
        {
            r.append("[");
            //追加内容

            Field[] fields = cl.getDeclaredFields();
            // 得到所有域的名字和值

            AccessibleObject.setAccessible(fields, true);
            //默认受限于Java的访问控制，如果没有受到安全管理器的控制，则可以用setAccessible覆盖访问控制
            for (Field f_temp : fields)
            {
                if (!Modifier.isStatic(f_temp.getModifiers()))   //判断是否包含static修饰符
                {
                    if (!r.toString().endsWith("["))    //如果不是以 [ 结尾
                        r.append(",");
                    r.append(f_temp.getName()).append("=");  //先增加f的对象信息，再追加一个等号
                    try
                    {
                        Class temp = f_temp.getType();
                        //返回由该对象表示的字段的声明类型的Class对象。
                        Object val = f_temp.get(obj);
                        //方法返回指定对象上由此Field表示的字段的值。
                        //如果该对象具有原始类型，则该值将自动包装在对象中

                        if (temp.isPrimitive())
                            //用来判断Class是否为原始类型
                            //（boolean、char、byte、short、int、long、float、double）
                            r.append(val);
                        else
                            r.append(toString(val));
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            r.append("]");
            cl = cl.getSuperclass();
        }
        while (cl != null);

        return r.toString();
    }
}
