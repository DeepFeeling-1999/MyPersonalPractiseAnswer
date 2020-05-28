package CoreJava.Chapter10_JFrame.SimpleFrame;

import javax.swing.*;
import java.awt.*;

/**
 * 所有的swing组件必须由“事件分派线程”进行配置
 * 线程将鼠标点击和按键控制转移到用户接口组件
 */
public class SimpleFrameTest {
    public static void main(String[] args) {

        //暂时看作启动一个swing程序的代码
        EventQueue.invokeLater(() -> {
            SimpleFrame test = new SimpleFrame();

            //定义一个用户关闭这个框架时的响应动作，此处是默认操作
            test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //起初是不可见的，可以在显示之前添加组件
            test.setVisible(true);

            /*
                初始化语句结束后，main退出，main退出并没有终止程序
                终止的只是主线程，而“事件分派线程”处于激活状态，
                直到关闭框架或用System.exit方法终止
             */
        });
    }
}

class SimpleFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public SimpleFrame() {

        //setLocation(1000,100);

        //设置位置和大小，Bounds---边界，范围
        setBounds(500, 100, 300, 300);
        //setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}