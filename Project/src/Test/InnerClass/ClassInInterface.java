package Test.InnerClass;

//接口中的类，方法都自动是public和static的
interface testInterface {
    //相当于创建公共代码，使他们可以被所有不同的实现所共用
    //多余的public static修饰符
    public static class test {
        static void fun(testInterface i) {
            i.InterfaceFun();
        }
    }

    void InterfaceFun();
}

public class ClassInInterface implements testInterface {
    public void InterfaceFun() {
        System.out.println("main interface function");
    }

    public static void main(String[] args) {
        ClassInInterface t = new ClassInInterface();

        //直接调用接口内的类方法
        testInterface.test.fun(t);
    }
}

