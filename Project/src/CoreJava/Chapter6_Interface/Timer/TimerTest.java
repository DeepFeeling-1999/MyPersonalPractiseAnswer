package CoreJava.Chapter6_Interface.Timer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimerTest {
    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();
        //构造监听器

        Timer t = new Timer(1000, listener);
        //调用监听器的计时器
        //要求实现actionPerformed接口，每到达指定的时间间隔就调用一次actionPerformed方法

        t.start();      //启动计时器

        JOptionPane.showMessageDialog(null, "Quit program?");
        //显示一个包含一条消息和OK的对话框，位于parent组件的中央，
        //若parent为null，则显示在屏幕中央

        System.exit(0);
    }
}

class TimePrinter implements ActionListener {
    //每到达指定的时间间隔就调用一次actionPerformed方法
    public void actionPerformed(ActionEvent event) {
        System.out.println("At the tone, the time is " + new Date());
    }
}
