package ThinkingInJava.Practise354_400.Practise383;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


class temp1 {
    public temp1() {

    }
}

class temp11 extends temp1 {
    private String location;
    private Integer area;

    public temp11() {
        location = null;
    }

    public temp11(Integer area) {
        this.area = area;
    }

    public temp11(String location) {
        this.location = location;
    }

    public temp11(String location, Integer area) {
        this.location = location;
        this.area = area;
    }

    public String toString() {
        return "House" + ((location == null) ? "" : " in " + location) + ((area != null) ? (", " + area + " sqft") : "");
    }
}

public class t22<T> {
    Class<?> kind;

    public t22(Class<?> kind) {
        this.kind = kind;
    }

    public Object fun1(String st) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return Class.forName(st).getDeclaredConstructor().newInstance();
    }

    public Object fun2(String st, Object... args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        switch (args.length) {
            case 1:
                return Class.forName(st).getDeclaredConstructor(args[0].getClass()).newInstance(args[0]);
            case 2:
                return Class.forName(st).getDeclaredConstructor(args[0].getClass(), args[1].getClass()).newInstance(args[0], args[1]);
        }
        return null;
    }

    public static void main(String[] args) {
        t22<temp1> t221 = new t22<>(temp1.class);
        t22<temp11> t222 = new t22<>(temp11.class);

        try {
            temp1 t1 = (temp1) t221.fun1("ThinkingInJava.Practise354_400.Practise383.temp1");
            System.out.println(t1);
            System.out.println("****************");

            Constructor[] ctors = temp11.class.getDeclaredConstructors();
            for (Constructor c : ctors) {
                System.out.println(c);
            }

            System.out.println("****************");

            temp11 t11 = (temp11) t222.fun2("ThinkingInJava.Practise354_400.Practise383.temp11", "aaa", 666);
            System.out.println(t11);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}




/*

class Building {
    public Building(){

    }
}
class House extends Building {
    private String location;
    private Integer area;
    public House() { location = null; }
    public House(Integer area) { this.area = area; }
    public House(String location) {
        this.location = location;
    }
    public House(String location, Integer area) {
        this.location = location;
        this.area = area;
    }
    public String toString() {
        return "House" + ((location == null) ? "" :  " in " + location) +
                ((area != null) ? (", "+ area + " sqft") : "");
    }
}

public class ClassTypeCreator22<T> {
    Class<?> kind;
    public ClassTypeCreator22(Class<?> kind) {
        this.kind = kind;
    }
    public Object createNew(String typename) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        return Class.forName(typename).getDeclaredConstructor().newInstance();
    }
    /** To create instance of typename with constructors taking arguments args: */
/*
    public Object createNew(String typename, Object... args)
            throws 	IllegalAccessException,
            InstantiationException,
            ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException {
        switch(args.length) {
            case 1 : return Class.forName(typename).getConstructor(args[0].getClass()).newInstance(args[0]);
            case 2 : return Class.forName(typename).getConstructor(args[0].getClass(), args[1].getClass()).
                    newInstance(args[0], args[1]);
        }
        return null;
    }
    public static void main(String[] args) {
        ClassTypeCreator22<Building> ctcb = new ClassTypeCreator22<Building>(Building.class);
        ClassTypeCreator22<House> ctch = new ClassTypeCreator22<House>(House.class);
        try {
            Building b = (Building)ctcb.createNew("Building");
            // To show we can access and print House constructors:
            System.out.println("House constructors:");
            Constructor[] ctors = House.class.getConstructors();
            for(Constructor ctor : ctors) System.out.println(ctor);
            // create 3 new House objects:
            House h = (House)ctch.createNew("House", "Hawaii");
            House h2 = (House)ctch.createNew("House", 3000);
            House h3 = (House)ctch.createNew("House", "Manila", 5000);
            System.out.println("Constructed House objects:");
            System.out.println(h);
            System.out.println(h2);
            System.out.println(h3);
        } catch(IllegalAccessException e) {

        } catch(InstantiationException e) {

        } catch(ClassNotFoundException e) {

        } catch(NoSuchMethodException e) {

        } catch(InvocationTargetException e) {

        }
    }
}
*/