package Test.getClass_class;
import java.util.Scanner;

abstract class Animal {
}

public class Dog extends Animal {
    public static void main(String[] args) throws ClassNotFoundException {
        Animal animal = new Dog();


        System.out.println(Double.class);
        //class java.lang.Object

        System.out.println(animal.getClass().getName());
        //输出Test.getClass_class.Dog
        //animal.getClass().getName()是在程序运行时获得运行时实例的类类型。

        System.out.println(Animal.class.getName());
        //输出Test.getClass_class.Animal
        // 而Animal.class.getName()是在编译阶段就确定了的，与运行时的状态无关。
    }
}
