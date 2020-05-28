package CoreJava.Chapter10_JFrame.paintComponent;

import javax.swing.*;
import java.awt.*;

public class NoHelloWorld {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new testFrame();
            frame.setTitle("hello!");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class testFrame extends JFrame {
    public testFrame() {
        //增加这个组件
        add(new testFrameComponent());

        //只想使用他们的首选大小
        //会调用getPreferredSize方法来获取首选大小
        pack();
    }
}

/**
 * 绘制一个组件，需要定义一个扩展JComponent的类
 * 并覆盖其中的paintComponent
 */
class testFrameComponent extends JComponent {
    public static final int DEFAULT_WIDTH = 900;
    public static final int DEFAULT_HEIGHT = 600;

    public static final int MESSAGE_X = 250;
    public static final int MESSAGE_Y = 500;

    /**
     * 不需要手动调用，需要重新绘图的时候会自动调用
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        /**显示文本
         * 位置，从左到右，从上到下的像素位置，
         * 此例中，文本的基线基于100
         */
        g.drawString("Not a hhh", MESSAGE_X, MESSAGE_Y);
    }

    /**
     * 返回一个有首选宽度和高度的Dimension类对象
     * <p>
     * 暂时认为是默认的大小，（首选的大小）
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
