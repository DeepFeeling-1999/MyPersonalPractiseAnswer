package Chapter6_Interface.InnerClass.InnerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * 内部类
 * 内部类可以访问该类定义所在作用域中的数据，包括私有的数据域
 * 内部类可以对同一个包中的其他类隐藏起来
 *
 * 只有内部类可以是私有类
 * 若是私有内部类，则只有方法可以构建内部类对象
 *
 * 内部类中的所有静态域必须是final
 */
public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(1000, false);
        clock.start();

        // 保持程序运行，直到选择 "Ok"
        JOptionPane.showMessageDialog(null, "Quit program?");
        //显示一个包含一条消息和OK的对话框，位于parent组件的中央，
        //若parent为null，则显示在屏幕中央

        System.exit(0);
    }
}

class TalkingClock
{
    private int interval;
    private boolean beep;


    public TalkingClock(int interval, boolean beep)
    {
        this.interval = interval;
        this.beep = beep;
    }

    //启迪计时器
    public void start()
    {
        ActionListener listener = new TimePrinter();
        //构造内部类实例

        Timer t = new Timer(interval, listener);
        t.start();
    }

    //内部类，用于构造监听器，所以实现了ActionListener接口
    public class TimePrinter implements ActionListener
    {
        private int num;
        public void pri(){
            System.out.println("aaaaaa");

        }
        public void actionPerformed(ActionEvent event) {
            System.out.println("At the tone, the time is " + new Date());
            if (beep)       //此处是使用的外部类的域
                Toolkit.getDefaultToolkit().beep();
        }
    }
}
