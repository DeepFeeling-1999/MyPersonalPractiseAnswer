package ThinkingInJava.Practise201_250.Practise203;

//接口中的类，方法都自动是public和static的
interface ClassInInterface {

    //相当于创建公共代码，使他们可以被所有不同的实现所共用
    //多余的public static修饰符
    public static class test {
        static void fun(ClassInInterface i) {
            i.InterfaceFun();
        }
    }

    void InterfaceFun();
}

public class t21 implements ClassInInterface {
    public void InterfaceFun() {
        System.out.println("main interface function");
    }

    public static void main(String[] args) {
        t21 t = new t21();

        //直接调用接口内的类方法
        ClassInInterface.test.fun(t);
    }
}
