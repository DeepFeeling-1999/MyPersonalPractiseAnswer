package CoreJava.Chapter6_Interface.InnerClass.Local_Anonymous;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class LocalAnonymousTest {
    /**
     * 局部类有自己的类名，定义完成之后需要再用new关键字实例化才可以使用；
     * <p>
     * 匿名类在定义的时候就实例化了，定义完了就可以直接使用；
     * 匿名类是一个表达式，因此在定义的最后用分号";"结束。
     * <p>
     * 局部内部类
     * 局部内部类是定义在一个方法或者一个作用域里面的类，
     * 它和成员内部类的区别在于局部内部类的访问仅限于方法内或者该作用域内。
     * 注意，局部内部类就像是方法里面的一个局部变量一样，
     * 是不能有public、protected、private以及static修饰符的。
     */
    public void start1() {
        class timePrint implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("The time is " + new Date());
            }
        }

        ActionListener listener = new timePrint();
        Timer t = new Timer(1000, listener);
        t.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        //显示一个包含一条消息和OK的对话框，位于parent组件的中央
        //若parent为null，则显示在屏幕中央
    }

    public static void start2() {
        /**匿名内部类
         * 匿名内部类就是没有名字的内部类；
         * 匿名内部类不能定义任何静态成员、方法。
         *
         * 匿名内部类中的方法不能是抽象的；
         * 匿名内部类必须实现接口或抽象父类的所有抽象方法。
         * 匿名内部类访问的外部类成员变量或成员方法必须用static修饰；
         */

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("The time is " + new Date());
            }
        };

        Timer t = new Timer(1000, listener);
        t.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        //显示一个包含一条消息和OK的对话框，位于parent组件的中央，
        //若parent为null，则显示在屏幕中央
    }

    public static void main(String[] args) {

        //start1();
        start2();

        System.exit(0);
    }
}
