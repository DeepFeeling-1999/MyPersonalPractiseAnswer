package CoreJava.Chapter10_JFrame.Ellipse2D;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class Ellipse2DTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new DrawFrame();
            frame.setTitle("Ellipse2DTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class DrawFrame extends JFrame {
    public DrawFrame() {
        //增加这个组件
        add(new DrawComponent());

        //只想使用他们的首选大小
        //会调用getPreferredSize方法来获取首选大小
        pack();
    }
}

class DrawComponent extends JComponent {
    public static final int DEFAULT_WIDTH = 400;
    public static final int DEFAULT_HEIGHT = 400;

    /**
     * 不需要手动调用，需要重新绘图的时候会自动调用
     *
     * @param p
     */
    @Override
    public void paintComponent(Graphics p) {
        Graphics2D graphics2D = (Graphics2D) p;

        double LeftX = 100;
        double TopY = 100;
        double Width = 200;
        double Height = 150;

        //绘制矩形
        Rectangle2D rec = new Rectangle2D.Double(100, 100, Width, Height);
        ((Graphics2D) p).draw(rec);

        //绘制封闭的椭圆
        Ellipse2D ellipse = new Ellipse2D.Double();
        //设置在矩形内
        ellipse.setFrame(rec);
        graphics2D.draw(ellipse);

        //绘制线
        graphics2D.draw(new Line2D.Double(LeftX, TopY, LeftX + Width, TopY + Height));
        graphics2D.draw(new Line2D.Double(LeftX, TopY + Height, LeftX + Width, TopY));

        //在同一个中心画一个圆
        double centerX = rec.getCenterX();
        double centerY = rec.getCenterY();
        double radius = 150;

        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
        graphics2D.draw(circle);
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
