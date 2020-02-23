package Test.interface_conflict;

/**
1、类中的方法优先级最高，类和父类中声明的方法优先级高于任何声明为默认方法的优先级；

2、类中无任何声明，子接口的优先级更高，高于任何声明为默认方法的优先级；(接口继承时)

3、以上不满足，继承了多接口的类必须通过显式覆盖和调用期望的方法，显式的选择哪种默认方法；
* */
public class ConflictTest extends SuperClass implements test1,test2{
    public static void main(String[]args){

        new ConflictTest().print(0);
        new ExtendsClass().print(0);
        new SuperClass().print(0);

    }
}

class SuperClass implements test1,test2{
   /* public void print(int n)
    {
        System.out.println("superClass interface");
    }*/
}

class ExtendsClass extends SuperClass implements test1,test2{
    public void print(int n) {
        System.out.println("extendsClass interface");
    }
}
