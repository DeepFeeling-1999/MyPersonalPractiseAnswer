package ThinkingInJava.Practise301_350.Practise350;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class temp{
    private int num1=111;
    protected int num2=222;

    private void fun1(){
        System.out.println("private void fun1() + "+num1);
    }

    protected void fun2(){
        System.out.println("protected void fun2() + "+num2);
    }
}
public class t25 {
    public static void callHiddenMethod(Object o,String methodName)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method=o.getClass().getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(o);
    }
    public static void main(String[]args)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
       callHiddenMethod(new temp(),"fun1");
        callHiddenMethod(new temp(),"fun2");
    }
}
