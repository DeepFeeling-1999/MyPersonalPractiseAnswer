package ThinkingInJava.Practise354_400.Practise381;

import SomeInstance.temp1;
import SomeInstance.temp11;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class t21<T> {
    Class<?> kind;
    Map<String, Class<?>> myMap;

    public t21(Class<?> kind, Map<String, Class<?>> myMap) {
        this.myMap = myMap;
        this.kind = kind;
    }

    public boolean fun(Object o) {
        return kind.isInstance(o);
    }

    public void addType(String typeName, Class<?> kind) {
        myMap.put(typeName, kind);
    }

    public Object creatNew(String typeName) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        try {
            if (myMap.containsKey(typeName)) {
                return myMap.get(typeName).getDeclaredConstructor().newInstance();
            }
        } catch (Exception e) {
            System.out.println("Exception!");
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        t21<temp1> t = new t21<>(temp1.class, new HashMap<>());

        t.addType("temp1", temp1.class);
        t.addType("temp11", temp11.class);

        System.out.println(t.fun(new temp1()));
        System.out.println(t.fun(new temp11()));

        System.out.println(t.creatNew("temp1"));
        System.out.println(t.creatNew("temp11"));
    }
}
