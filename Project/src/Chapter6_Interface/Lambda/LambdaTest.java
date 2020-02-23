package Chapter6_Interface.Lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Date;

/**
 * lambda表达式定义代码块
 * 若lambda表达式没有参数，任然要写（）
 * 若参数类型可以推导出，则可以忽略其类型
 * 若只有一个参数，且可以推导出其类型，则可以省略括号
 * 如果lambda表达式只在某一个分支中有返回值，在另一些分支中不返回，是不合法的
 */
public class LambdaTest {
    public static void main(String[] args)
    {
        String[] planets = new String[]{ "Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune" };

        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");

        Arrays.sort(planets);       //排序
        System.out.println(Arrays.toString(planets));

        System.out.println("Sorted by length:");

        /**
         * 用lambda表达式代替Comparator<String>比较器
         * 在底层，Array.sort方法会接收实现了Comparator<String>接口的某个类的对象
         * 在这个对象上调用compare方法会执行这个lambda表达式的体
         *
         * 此处转换为只有一个方法的接口，称为函数式接口，即lambda表达式可以传递到函数式接口
         */
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));

        //可以自动推导出类型为ActionEvent
        Timer t = new Timer(1000,  event->
                System.out.println("The time is " + new Date()));
        //调用监听器的计时器
        //要求实现actionPerformed接口，每到达指定的时间间隔就调用一次actionPerformed方法
        //用lambda表达式代替监听器

        t.start();      //启动计时器
        JOptionPane.showMessageDialog(null, "Quit program?");
        //显示一个包含一条消息和OK的对话框，位于parent组件的中央，
        //若parent为null，则显示在屏幕中央

        System.exit(0);
    }
}
