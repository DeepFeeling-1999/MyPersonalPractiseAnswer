package ThinkingInJava.Practise301_350.Practise340;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandle implements InvocationHandler {
    private static int amount = 0;
    private Object proxied;

    public DynamicProxyHandle(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("DynamicProxyHandle invoke ");
        if (args != null) {
            for (Object o : args)
                System.out.println("args : " + o);
        }
        amount++;
        return method.invoke(proxied, args);
    }
}


public class t22 {
    public static void fun(MyInterface i) {
        i.doSomething();
        i.somethingElse();
    }

    public static void main(String[] args) {
        temp t = new temp();
        fun(t);

        MyInterface myProxy = (MyInterface) Proxy.newProxyInstance(MyInterface.class.getClassLoader(), new Class[]{MyInterface.class}, new DynamicProxyHandle(t));

        fun(myProxy);
    }
}