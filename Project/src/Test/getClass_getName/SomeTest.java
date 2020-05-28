package Test.getClass_getName;

import java.util.Date;

class SomeTest extends Date {
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        new SomeTest().print();
    }

    public SomeTest() {

    }

    public void print() {
        System.out.println("当前运行类的名字为:" + super.getClass().getName());
        System.out.println("当前运行类的名字为:" + this.getClass().getName());
        System.out.println("当前运行类的继承的父类的名字为:" + this.getClass().getSuperclass());
    }
}