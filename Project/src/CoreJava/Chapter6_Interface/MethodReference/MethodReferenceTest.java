package CoreJava.Chapter6_Interface.MethodReference;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Date;

/**
 * 方法引用
 * 1，object::instanceMethod
 * 2,Class::staticMethod
 * 3,Class::instanceMethod
 * 前两种等价于提供方法参数的lambda表达式
 * 第三种第一个参数会成为方法的目标
 * 如 String::compareToIgnoreCase等价于(x,y)->x.compareToIgnoreCase(y)
 */
public class MethodReferenceTest {
    public static void main(String[] args) {
        Timer t = new Timer(1000, Test::Print);

        t.start();      //启动计时器
        JOptionPane.showMessageDialog(null, "Quit program?");
        //显示一个包含一条消息和OK的对话框，位于parent组件的中央，
        //若parent为null，则显示在屏幕中央

        System.exit(0);         //需要加上这句，不然会继续运行,直到程序结束才停止
    }
}

class Test {
    public static void Print(ActionEvent action) {
        System.out.println("time is " + new Date());
    }
}
